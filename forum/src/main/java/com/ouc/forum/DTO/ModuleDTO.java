package com.ouc.forum.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author fxjy
 * @Date 2020/9/12 0:20
 * @Version 1.0
 */
@ApiModel(value = "模块信息")
public class ModuleDTO {
    @ApiModelProperty(value = "版块ID")
    private long id;
    @ApiModelProperty(value = "版块名")
    private String name;
    @ApiModelProperty(value = "封面")
    private String cover;
    @ApiModelProperty(value = "版块信息")
    private String info;
    @ApiModelProperty(value = "贴数量")
    private Long tieNum;

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

    public Long getTieNum() {
        return tieNum;
    }

    public void setTieNum(Long tieNum) {
        this.tieNum = tieNum;
    }

    @Override
    public String toString() {
        return "ModuleDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cover='" + cover + '\'' +
                ", info='" + info + '\'' +
                ", tieNum=" + tieNum +
                '}';
    }
}
