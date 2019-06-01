package com.gavin.initalizestart.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * 描述：User 实体
 * 创建时间: 2018年7月5日 下午2:22:21 
 *
 * @author gang.yan
 */
@Entity
@XmlRootElement // MediaType 转为 XML
public class User {

    @Id  // 主键
    @GeneratedValue(strategy=GenerationType.IDENTITY) // 自增长策略
    private Long id;

    @NotEmpty(message = "姓名不能为空")
    @Size(min=2,max =20)
    private String name;

    @NotEmpty(message = "邮箱不能为空")
    @Size(max = 50)
    @Email(message = "邮箱格式有误")
    private String email;

    @NotEmpty(message = "账号不能为空")
    @Size(min = 3 ,max = 20)
    @Column(nullable = false,length = 20,unique = true)
    private String username;

    @NotEmpty(message = "密码不能为空")
    @Size(min = 3,max = 100)
    @Column(length = 100)
    private String password;

    @Column(length = 200)
    private String avatar;

    protected User() {  // JPA 的规范要求无参构造函数；设为 protected 防止直接使用

    }
    public User(Long id,String name,String username,String email) {
        this.id = id;//实体一个唯一标识
        this.name = name;
        this.email = email;
        this.username = username;

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, name='%s', email='%d']",
                id, name, email);
    }
}
