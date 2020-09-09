package com.ouc.forum.DTO;

/**
 * @author sunhaojie
 * @version 1.0
 * @date 2020/9/9 11:24
 */
public class TestDTO {
    int num;
    String content;

    public TestDTO() {
    }

    @Override
    public String toString() {
        return "TestDTO{" +
                "num=" + num +
                ", content='" + content + '\'' +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
