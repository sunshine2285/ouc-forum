package com.ouc.forum.DTO;

import com.ouc.forum.entity.Comment;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

/**
 * @author sunhaojie
 * @version 1.0
 * @date 2020/9/12 14:50
 */
@ApiModel("评论DTO")
public class CommentDTO {
    @ApiModelProperty(value = "评论ID")
    private Long id;
    @ApiModelProperty(value = "评论回帖ID")
    private Long rid;
    @ApiModelProperty(value = "评论@的评论ID")
    private Long cid;
    @ApiModelProperty(value = "评论@的评论的用户名")
    private String atUsername;
    @ApiModelProperty(value = "评论用户ID")
    private Long uid;
    @ApiModelProperty(value = "评论用户名")
    private String username;
    @ApiModelProperty(value = "评论用户头像")
    private String avatar;
    @ApiModelProperty(value = "评论内容")
    private String content;
    @ApiModelProperty(value = "发帖时间")
    private java.sql.Timestamp postTime;

    public CommentDTO(Comment comment) {
        this.id = comment.getId();
        this.rid = comment.getRid();
        this.cid = comment.getCid();
        this.uid = comment.getUid();
        this.content = comment.getContent();
        this.postTime = comment.getPostTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getAtUsername() {
        return atUsername;
    }

    public void setAtUsername(String atUsername) {
        this.atUsername = atUsername;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getPostTime() {
        return postTime;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "id=" + id +
                ", rid=" + rid +
                ", cid=" + cid +
                ", atUsername='" + atUsername + '\'' +
                ", uid=" + uid +
                ", username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                ", content='" + content + '\'' +
                ", postTime=" + postTime +
                '}';
    }
}
