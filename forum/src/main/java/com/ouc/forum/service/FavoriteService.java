package com.ouc.forum.service;

import com.ouc.forum.entity.Favorite;
import com.ouc.forum.repository.FavoriteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author sunhaojie
 * @version 1.0
 * @date 2020/9/9 10:23
 */
@Service
public class FavoriteService {

    final FavoriteRepository favoriteRepository;

    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    public ArrayList<Favorite> selectAll(long uid) {
        //todo: 从repository获取所有用户id为uid的收藏
        ArrayList<Favorite> userFavorites = favoriteRepository.findAllByUid(uid);

        return userFavorites;
    }

    public void delete(long uid, long tid) {
        //todo: 调用 jpa 接口删除对应 favorite
        // favoriteRepository.findAllByUid(uid);
    }

    public Favorite save(Favorite favorite) {
        //todo: 调用 jpa save favorite，返回存储之后的favorite
        return favorite;
    }
}
