package com.gavin.initalizestart.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "comment_bl")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    //用户唯一标示
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //  @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
    private Long id;

    //评论内容
    @NotEmpty(message = "评论内容不能为空")
    @Size(min = 2, max = 500)
    private String content;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    @org.hibernate.annotations.CreationTimestamp  //由数据自动创建时间
    private Timestamp createTime;

    protected Comment() {
    }

    public Comment(User user, String content) {
        this.content = content;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

}
