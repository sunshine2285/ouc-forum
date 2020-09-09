package com.ouc.forum.repository;

import com.ouc.forum.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author sunhaojie
 * @version 1.0
 * @date 2020/9/8 12:00
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByPhone(String phone);
    Optional<User> findByMail(String mail);
}
