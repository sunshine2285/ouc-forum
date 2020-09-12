package com.ouc.forum.service;

import com.ouc.forum.entity.Reply;
import com.ouc.forum.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author Song
 * @create 2020/9/10 0:15
 */
@Service
public class ReplyService {
    @Resource
    private ReplyRepository replyRepository;
    @Resource
    private TieService tieService;

    public List<Reply> getAllReply(long tid, int pageNum) {
        int PAGE_SIZE = 20;
        if (pageNum == 1) {
            Reply reply = new Reply(tieService.getTie(tid));
            Page<Reply> replyPage = replyRepository.findAll(PageRequest.of(0, PAGE_SIZE -1));
            ArrayList<Reply> replies = new ArrayList<>(replyPage.getContent());
            replies.add(0, reply);
            return replies;
        } else {
            Page<Reply> prePage = replyRepository.findAll(PageRequest.of(pageNum-1, PAGE_SIZE));
            Page<Reply> curPage = replyRepository.findAll(PageRequest.of(pageNum, PAGE_SIZE));
            ArrayList<Reply> replies = new ArrayList<>(curPage.getContent());
            replies.remove(replies.size()-1);
            replies.add(0, prePage.getContent().get(prePage.getSize()-1));
            return replies;
        }
    }

    public ArrayList<Reply> getUserReply(long uid) {
        return replyRepository.findAllByUid(uid);
    }

    public Reply createReply(Reply reply) {
        return replyRepository.save(reply);
    }

    public String deleteReply(long id) {
        replyRepository.deleteById(id);
        return "OK";
    }

    public String likeReply(long id) {
        return "OK";
    }
}
