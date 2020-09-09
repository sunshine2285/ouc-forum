package com.ouc.forum.repository;

import com.ouc.forum.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @author sunhaojie
 * @version 1.0
 * @date 2020/9/8 12:06
 */
@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    /**
     *  根据用户 uid 查询所有的收藏
     * @param uid qwe
     * @return {@link ArrayList<Favorite>}
     */
    @Query
    public ArrayList<Favorite> findAllByUid(long uid);

}
