package com.ouc.forum.service;

import com.ouc.forum.entity.Comment;
import com.ouc.forum.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * @author 孙浩杰
 * @date 2020/09/10 20:24
 */
@Service
public class CommentService {
    final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public ArrayList<Comment> getCommentFromTie(long rid) {
        return commentRepository.findAllByRid(rid);
    }

    public Comment addComment(Comment comment) {
        comment.setPostTime(new Timestamp(System.currentTimeMillis()));
        commentRepository.save(comment);
        return comment;
    }

    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }


}
