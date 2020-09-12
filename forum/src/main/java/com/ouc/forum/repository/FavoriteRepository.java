package com.ouc.forum.repository;

import com.ouc.forum.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author sunhaojie
 * @version 1.0
 * @date 2020/9/8 12:06
 */
@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    /**
     *  根据用户 uid 查询所有的收藏
     * @param uid 用户ID
     * @return {@link ArrayList<Favorite>}
     */
    @Query
    public ArrayList<Favorite> findAllByUid(long uid);

    /**
     * 根据用户ID和帖子ID返回收藏
     * @param uid 用户ID
     * @param tid 收藏贴ID
     * @return {@link Optional<Favorite>}
     */
    @Query
    public Optional<Favorite> findByUidAndTid(long uid, long tid);
}
