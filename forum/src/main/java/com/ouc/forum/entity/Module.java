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
@Entity
@ApiModel(value = "版块")
public class Module {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ApiModelProperty(value = "版块ID")
  private long id;
  @ApiModelProperty(value = "版块名")
  private String name;
  @ApiModelProperty(value = "封面")
  private String cover;
  @ApiModelProperty(value = "版块信息")
  private String info;
  @ApiModelProperty(value = "创建时间")
  private java.sql.Timestamp createTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getCover() {
    return cover;
  }

  public void setCover(String cover) {
    this.cover = cover;
  }


  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }

}
