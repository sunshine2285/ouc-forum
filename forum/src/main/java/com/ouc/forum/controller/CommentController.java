package com.ouc.forum.controller;

import com.ouc.forum.entity.Comment;
import com.ouc.forum.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author 孙浩杰
 * @date 2020/09/10 20:00
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/comment")
@Api(value = "对评论的操作",tags = "评论接口")
public class CommentController {
    final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{rid}}")
    @ApiOperation(value = "获取回帖下的评论",notes = "获取回帖下的所有评论")
    public ArrayList<Comment> getCommentFormTie(@PathVariable long rid) {
        return commentService.getCommentFromTie(rid);
    }

    @PostMapping(value = "/", consumes = "application/json")
    @ApiOperation(value = "新增评论",notes = "增加对某个帖子的评论")
    public Comment add(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除",notes = "删除自己的评论")
    public void delete(@PathVariable long id) {
        commentService.deleteComment(id);
    }
}
