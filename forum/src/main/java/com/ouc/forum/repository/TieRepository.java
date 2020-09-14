package com.ouc.forum.repository;

import com.ouc.forum.entity.Tie;
import com.ouc.forum.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @Author Song
 * @create 2020/9/10 0:15
 */
@Repository
public interface TieRepository extends JpaRepository<Tie, Long> {

    Page<Tie> findByMid(Long mid, Pageable pageable);

    @Query(value = "SELECT count(*) FROM tie WHERE mid =:mid",nativeQuery = true)
    long tieCount(@Param("mid") long mid);

    @Query
    ArrayList<Tie> findAllByMid(long mid);

    @Query
    Optional<Tie> findById(long id);

    @Query
    ArrayList<Tie> findAllByTitleLike(String key);

    @Query
    ArrayList<Tie> findAllByUid(long uid);

    @Modifying
    void deleteById(long id);

}
