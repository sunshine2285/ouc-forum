package com.ouc.forum.controller;

import com.ouc.forum.DTO.TestDTO;
import com.ouc.forum.entity.Favorite;
import com.ouc.forum.service.FavoriteService;
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
public class FavoriteController {

    final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping("/{uid}")
    public ArrayList<Favorite> get(@PathVariable long uid) {
        return favoriteService.selectAll(uid);
    }

    @PostMapping("/{uid}")
    public String test(@PathVariable long uid,TestDTO testDTO) {
        System.out.println(uid);
        System.out.println(testDTO);
        return testDTO.toString();
    }

    @DeleteMapping("/{uid}/{tid}")
    public void delete(@PathVariable long uid, @PathVariable long tid) {
        favoriteService.delete(uid, tid);
    }

    @PostMapping("/{uid}/{tid}")
    public Favorite add(@PathVariable long uid, @PathVariable long tid) {
        Favorite favorite = new Favorite();
        favorite.setUid(uid);
        favorite.setTid(tid);
        return favoriteService.save(favorite);
    }
}
