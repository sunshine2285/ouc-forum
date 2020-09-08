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
public class Notice {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long uid;
  private String content;
  private java.sql.Timestamp produceTime;
  private byte valid;


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


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public java.sql.Timestamp getProduceTime() {
    return produceTime;
  }

  public void setProduceTime(java.sql.Timestamp produceTime) {
    this.produceTime = produceTime;
  }


  public byte getValid() {
    return valid;
  }

  public void setValid(byte valid) {
    this.valid = valid;
  }

}
