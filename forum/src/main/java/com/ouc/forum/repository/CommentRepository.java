package com.ouc.forum.repository;

import com.ouc.forum.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @author sunhaojie
 * @version 1.0
 * @date 2020/9/8 12:07
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query
    ArrayList<Comment> findAllByRidAndCid(long rid, long cid);
    @Query
    ArrayList<Comment> findAllByRid(long rid);
}
