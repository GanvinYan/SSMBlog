package com.gavin.initalizestart.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * @Description: TODO
 * @Author: gang.yan
 * @Date: 2019/11/10 10:56
 * @Version: 1.0
 */
@Entity
public class Authority implements GrantedAuthority {

    private static final long SerialVersionUID = 1L;

    @Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
    private Long id; // 用户的唯一标识

    @Column(nullable = false) // 映射为字段，值不能为空
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    /**
     * 
     * @Description //TODO
     * @Param []
     * @return java.lang.String
     * @Author gang.yan
     * @Date 11:02 2019/11/10
     */
    @Override
    public String getAuthority(){
        System.out.println("----");
        return name;
    }
}

