package com.ouc.forum.controller;

import com.ouc.forum.DTO.TestDTO;
import com.ouc.forum.entity.Favorite;
import com.ouc.forum.service.FavoriteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author sunhaojie
 * @version 1.0
 * @date 2020/9/9 10:04
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/favorite")
@Api(value = "用户收藏接口", tags = "123")
public class FavoriteController {

    final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @ApiOperation(value = "获取用户收藏", notes = "根据用户ID获取用户所有收藏")
    @GetMapping("/{uid}")
    public ArrayList<Favorite> get(@PathVariable long uid) {
        return favoriteService.selectAll(uid);
    }

    @ApiOperation(value = "删除用户收藏", notes = "根据用户ID和帖子ID删除用户收藏")
    @DeleteMapping("/{uid}/{tid}")
    public void delete(@PathVariable long uid, @PathVariable long tid) {
        favoriteService.delete(uid, tid);
    }

    @ApiOperation(value = "添加用户收藏", notes = "根据用户ID和帖子ID为用户添加收藏")
    @PostMapping("/{uid}/{tid}")
    public Favorite add(@PathVariable long uid, @PathVariable long tid) {
        Favorite favorite = new Favorite();
        favorite.setUid(uid);
        favorite.setTid(tid);
        return favoriteService.save(favorite);
    }
}
