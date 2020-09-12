package com.ouc.forum.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;

/**
 * @Author fxjy
 * @Date 2020/9/9 13:07
 * @Version 1.0
 */
@ApiModel(value = "用户可更改信息")
public class UserInfoDTO {
    @ApiModelProperty(value = "用户名", required = true)
    private String username;
    @ApiModelProperty(value = "密码", required = true)
    private String password;
    @ApiModelProperty(value = "邮箱", required = true)
    private String mail;
    @ApiModelProperty(value = "手机号", required = true)
    private String phone;
    @ApiModelProperty(value = "头像")
    private String avatar;
    @ApiModelProperty(value = "性别")
    private byte sex;
    @ApiModelProperty(value = "生日")
    private Date birth;
    @ApiModelProperty(value = "学号")
    private String sno;
    @ApiModelProperty(value = "专业")
    private String major;
    @ApiModelProperty(value = "地区")
    private String location;
    @ApiModelProperty(value = "QQ")
    private String qq;
    @ApiModelProperty(value = "个性签名")
    private String motto;
    @ApiModelProperty(value = "经验")
    private int exp;
    @ApiModelProperty(value = "是否保密")
    private byte secrecy;

    public UserInfoDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public byte getSecrecy() {
        return secrecy;
    }

    public void setSecrecy(byte secrecy) {
        this.secrecy = secrecy;
    }

    @Override
    public String toString() {
        return "UserInfoDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", avatar='" + avatar + '\'' +
                ", sex=" + sex +
                ", birth=" + birth +
                ", sno='" + sno + '\'' +
                ", major='" + major + '\'' +
                ", location='" + location + '\'' +
                ", qq='" + qq + '\'' +
                ", motto='" + motto + '\'' +
                ", exp=" + exp +
                ", secrecy=" + secrecy +
                '}';
    }
}
