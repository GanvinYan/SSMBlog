package com.gavin.initalizestart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 描述：安全配置类
 * 创建时间: 2018年9月5日 下午9:19:55 
 *
 * @author gang.yan
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	/**
	 * 自定义配置
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/css/**","/js/**","/fonts/**","/index").permitAll() //都可以访问
			.antMatchers("/users/**").hasRole("ADMIN") //需要相应的角色才能访问
			.and()
			.formLogin() //基于From表单登录验证
			.loginPage("/login").failureUrl("/login-error")//自定义登录界面
			.and().exceptionHandling().accessDeniedPage("/403"); 
		http.csrf().ignoringAntMatchers("/h2-console/**"); // 禁用 H2 控制台的 CSRF 防护
		http.headers().frameOptions().sameOrigin(); // 允许来自同一来源的H2 控制台的请求
	}
	/**
	 * 认证信息管理
	 * 创建时间: 2018年9月5日 下午10:39:01 
	 * @param auth
	 * @throws Exception
	 * @author gang.yan
	 */
	@Autowired
	private void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
		.withUser("gang.yan").password("123456").roles("ADMIN");
	}
	
}
