package com.ouc.forum.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author sunhaojie
 * @version 1.0
 * @date 2020/9/8 11:05
 */
@Entity
public class Tie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long uid;
  private long mid;
  private String title;
  private String content;
  private java.sql.Timestamp postTime;
  private long view;
  private String tags;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getUid() {
    return uid;
  }

  public void setUid(long uid) {
    this.uid = uid;
  }


  public long getMid() {
    return mid;
  }

  public void setMid(long mid) {
    this.mid = mid;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
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


  public long getView() {
    return view;
  }

  public void setView(long view) {
    this.view = view;
  }


  public String getTags() {
    return tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

}
