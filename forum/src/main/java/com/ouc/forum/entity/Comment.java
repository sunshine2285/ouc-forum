package com.ouc.forum.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author sunhaojie
 * @version 1.0
 * @date 2020/9/8 11:05
 */
@ApiModel("评论")
@DynamicInsert(true)
@DynamicUpdate(true)
@Entity
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ApiModelProperty(value = "评论ID")
  private long id;
  @ApiModelProperty(value = "评论回帖ID")
  private long rid;
  @ApiModelProperty(value = "评论@的评论ID")
  private long cid;
  @ApiModelProperty(value = "评论用户ID")
  private long uid;
  @ApiModelProperty(value = "评论内容")
  private String content;
  @ApiModelProperty(value = "发帖时间")
  private java.sql.Timestamp postTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getRid() {
    return rid;
  }

  public void setRid(long rid) {
    this.rid = rid;
  }


  public long getCid() {
    return cid;
  }

  public void setCid(long cid) {
    this.cid = cid;
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
