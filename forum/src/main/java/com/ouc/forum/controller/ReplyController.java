package com.ouc.forum.controller;

import com.ouc.forum.entity.Reply;
import com.ouc.forum.service.ReplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Song
 * @create 2020/9/10 0:15
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/reply")
@Api(value = "回帖模块",tags = "回帖接口")
public class ReplyController {
    @Resource
    private ReplyService replyService;

    @GetMapping(value = "/tie/{tid}/{pageNum}",produces = "application/json")
    @ApiOperation(value = "获取某一帖子所有回帖",notes = "")
    public List<Reply> getAllReply(@PathVariable long tid, @PathVariable("pageNum") int pageNum) {
        return replyService.getAllReply(tid, pageNum);
    }

    @GetMapping(value = "/user/{uid}",produces = "application/json")
    @ApiOperation(value = "获取用户所有回帖",notes = "")
    public ArrayList<Reply> getUserReply(@PathVariable long uid) {
        return replyService.getUserReply(uid);
    }

    @PostMapping(value = "/create",produces = "application/json")
    @ApiOperation(value = "新增回帖",notes = "")
    public Reply createReply(@RequestBody Reply reply) {
        return replyService.createReply(reply);
    }

    @DeleteMapping(value = "/{id}",produces = "application/json")
    @ApiOperation(value = "删除回帖",notes = "")
    public String deleteReply(@PathVariable long id) {
        return replyService.deleteReply(id);
    }

    @PostMapping(value = "/like/{id}",produces = "application/json")
    @ApiOperation(value = "给回帖点赞",notes = "")
    public String likeReply(@PathVariable long id) {
        return replyService.likeReply(id);
    }
}
