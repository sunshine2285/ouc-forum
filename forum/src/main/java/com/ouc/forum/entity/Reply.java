package com.ouc.forum.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * @author sunhaojie
 * @version 1.0
 * @date 2020/9/8 11:05
 */
@Entity
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long tid;
    private long uid;
    private String content;
    private java.sql.Timestamp postTime;

    public Reply() {
    }

    public Reply(Tie tie) {
        this.id = tie.getId();
        this.tid = tie.getMid();
        this.uid = tie.getUid();
        this.content = tie.getContent();
        this.postTime = tie.getPostTime();
    }

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", tid=" + tid +
                ", uid=" + uid +
                ", content='" + content + '\'' +
                ", postTime=" + postTime +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getTid() {
        return tid;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }


    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public java.sql.Timestamp getPostTime() {
        return postTime;
    }

    public void setPostTime(java.sql.Timestamp postTime) {
        this.postTime = postTime;
    }

}
