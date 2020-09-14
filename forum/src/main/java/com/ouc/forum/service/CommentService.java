package com.ouc.forum.service;

import com.ouc.forum.DTO.CommentDTO;
import com.ouc.forum.entity.Comment;
import com.ouc.forum.entity.User;
import com.ouc.forum.repository.CommentRepository;
import com.ouc.forum.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author 孙浩杰
 * @date 2020/09/10 20:24
 */
@Service
public class CommentService {
    final CommentRepository commentRepository;
    final UserRepository userRepository;

    public CommentService(CommentRepository commentRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    private CommentDTO comment2Dto(Comment comment) {
        CommentDTO commentDTO = new CommentDTO(comment);
        Optional<User> userOptional = userRepository.findById(comment.getUid());
        userOptional.ifPresent(user -> {
            commentDTO.setUsername(user.getUsername());
            commentDTO.setAvatar(user.getAvatar());
        });
        Optional<Comment> commentOptional = commentRepository.findById(commentDTO.getCid());
        commentOptional.ifPresent(atComment -> {
            Optional<User> atUserOptional = userRepository.findById(comment.getUid());
            atUserOptional.ifPresent(atUser -> commentDTO.setAtUsername(atUser.getUsername()));
        });
        return commentDTO;
    }

    public List<CommentDTO> getComments(long rid) {
        List<Comment> commentList = commentRepository.findAllByRid(rid);
        List<CommentDTO> commentDTOList = new ArrayList<>();
        commentList.forEach(comment -> commentDTOList.add(comment2Dto(comment)));
        return commentDTOList;
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
