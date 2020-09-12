package com.ouc.forum.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author fxjy
 * @Date 2020/9/12 9:35
 * @Version 1.0
 */
@ApiModel(value = "用户基本信息")
public class UserBIDTO {
    @ApiModelProperty(value = "用户名", required = true)
    private String username;
    @ApiModelProperty(value = "头像")
    private String avatar;
    @ApiModelProperty(value = "性别")
    private byte sex;
    @ApiModelProperty(value = "个性签名")
    private String motto;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    @Override
    public String toString() {
        return "UserBIDTO{" +
                "username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                ", sex=" + sex +
                ", motto='" + motto + '\'' +
                '}';
    }
}
