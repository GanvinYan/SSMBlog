package com.gavin.initalizestart.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * vote 实体
 * @author gang
 * @since 2020.02.04
 */
@Entity
public class Vote implements Serializable {
    private  static final long serialVersionUId = 1L;

    /**
     * 用户唯一标识
     */
    @Id //主键
    //  @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    /**
     * 用户
     */
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="user_id")
    private User user;

    /**
     * 创建时间
     */
    @Column(nullable = false)//映射字段，值不能为空
    @org.hibernate.annotations.CreationTimestamp //由数据库自动创建时间
    private Timestamp createTime;

    protected Vote(){
    }

    public Vote (User user){
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
