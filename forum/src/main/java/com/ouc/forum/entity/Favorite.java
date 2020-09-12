package com.ouc.forum.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author sunhaojie
 * @version 1.0
 * @date 2020/9/8 11:05
 */
@ApiModel("收藏")
@Entity
public class Favorite {

  @ApiModelProperty(value = "收藏ID")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @ApiModelProperty(value = "收藏贴ID")
  private long tid;
  @ApiModelProperty(value = "用户ID")
  private long uid;


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

}
