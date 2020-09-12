package com.ouc.forum.repository;

import com.ouc.forum.entity.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @Author Song
 * @create 2020/9/10 0:15
 */
@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
//    @Query
//    ArrayList<Reply> findAllByTid(long tid);
    @Query(value = "SELECT count(*) FROM reply WHERE tid = :tid",nativeQuery = true)
    long replyCount(@Param("tid") long tid);


    @Query
    Page<Reply> findAllByTid(long tid, Pageable pageable);

    @Query
    ArrayList<Reply> findAllByUid(long uid);

    @Modifying
    void deleteById(long id);
}
