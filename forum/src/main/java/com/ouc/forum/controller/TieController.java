package com.ouc.forum.controller;

import com.ouc.forum.DTO.TieDTO;
import com.ouc.forum.entity.Tie;
import com.ouc.forum.service.TieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @Author Song
 * @create 2020/9/10 0:15
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/tie")
@Api(value = "帖子模块",tags = "帖子接口")
public class TieController {
    @Resource
    private TieService tieService;

    @GetMapping(value = "/module/{mid}",produces = "application/json")
    @ApiOperation(value = "根据板块ID获取某板块下所有帖子",notes = "")
    public ArrayList<Tie> getAllTie(@PathVariable long mid) {
        return tieService.getAllTie(mid);
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    @ApiOperation(value = "根据帖子ID获取某帖子",notes = "")
    public TieDTO getTie(@PathVariable long id) {
        return tieService.getTie(id, true);
    }

    @GetMapping(value = "/search/{key}",produces = "application/json")
    @ApiOperation(value = "根据关键词查询帖子",notes = "")
    public ArrayList<Tie> searchTie(@PathVariable String key) {
        return tieService.searchTie(key);
    }

    @PostMapping(value = "",produces = "application/json")
    @ApiOperation(value = "新建帖子",notes = "")
    public Tie createTie(@RequestBody Tie tie){
        return tieService.createTie(tie);
    }

    @GetMapping(value = "/search/hot/{count}",produces = "application/json")
    @ApiOperation(value = "查询热帖",notes = "")
    public ArrayList<TieDTO> searchHotTie(@PathVariable int count) {
        return tieService.searchHotTie(count);
    }

    @GetMapping(value = "/search/user/{uid}",produces = "application/json")
    @ApiOperation(value = "获取用户所有发帖",notes = "")
    public ArrayList<Tie> getUserTie(@PathVariable long uid) {
        return tieService.getUserTie(uid);
    }

    @DeleteMapping(value = "/{id}",produces = "application/json")
    @ApiOperation(value = "删除帖子",notes = "")
    public String deleteTie(@PathVariable long id){
        tieService.deleteTie(id);
        return "OK";
    }

    @PostMapping(value = "/like/{id}",produces = "application/json")
    @ApiOperation(value = "给主帖点赞",notes = "")
    public String likeTie(@PathVariable long id){
        return tieService.likeTie(id);
    }
}
