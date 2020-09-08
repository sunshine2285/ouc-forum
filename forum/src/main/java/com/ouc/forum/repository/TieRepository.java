package com.ouc.forum.repository;

import com.ouc.forum.entity.Tie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sunhaojie
 * @version 1.0
 * @date 2020/9/8 12:02
 */
@Repository
public interface TieRepository extends JpaRepository<Tie, Long> {
}
