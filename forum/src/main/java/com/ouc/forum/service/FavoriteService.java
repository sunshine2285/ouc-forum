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
        return favoriteRepository.findAllByUid(uid);
    }

    public void delete(long uid, long tid) {
        favoriteRepository.findByUidAndTid(uid, tid).ifPresent(favorite -> {
            favoriteRepository.deleteById(favorite.getId());
        });
    }

    public Favorite save(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }
}
