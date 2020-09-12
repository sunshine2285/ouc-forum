package com.ouc.forum.DTO;

import com.ouc.forum.entity.Tie;

/**
 * @Author Song
 * @create 2020/9/11 23:52
 */
public class TieDTO extends Tie{
    public TieDTO(Tie tie, long replyNum) {
        super(tie);
        this.replyNum = replyNum;
    }

    private long replyNum;

    public long getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(long replyNum) {
        this.replyNum = replyNum;
    }
}
