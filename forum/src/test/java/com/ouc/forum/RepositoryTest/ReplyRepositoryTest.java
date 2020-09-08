package com.ouc.forum.RepositoryTest;

import com.ouc.forum.entity.Reply;
import com.ouc.forum.repository.ReplyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

/**
 * @author sunhaojie
 * @version 1.0
 * @date 2020/9/8 12:10
 */
@SpringBootTest
public class ReplyRepositoryTest {

    @Autowired
    ReplyRepository replyRepository;

    @Test
    void saveTest(){
        Reply reply = new Reply();
        reply.setUid(1);
        reply.setTid(2);
        reply.setContent("this is a test reply content");
        reply.setPostTime(new Timestamp(System.currentTimeMillis()));
        reply = replyRepository.save(reply);
        System.out.println(reply);
    }
    @Test
    void updateTest(){
        Reply reply = new Reply();
        // reply.set
        reply.setUid(1);
        reply.setTid(2);
        reply.setContent("this is a update reply content");
        reply.setPostTime(new Timestamp(System.currentTimeMillis()));
        reply = replyRepository.save(reply);
        System.out.println(reply);
    }
}
