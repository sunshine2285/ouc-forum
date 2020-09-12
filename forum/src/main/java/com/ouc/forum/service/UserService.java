package com.ouc.forum.service;

import com.ouc.forum.DTO.UserInfoDTO;
import com.ouc.forum.DTO.UserRLDTO;
import com.ouc.forum.entity.User;
import com.ouc.forum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

/**
 * @Author fxjy
 * @Date 2020/9/9 12:07
 * @Version 1.0
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean validateMail(String mail) {
        return !userRepository.findByMail(mail).isPresent();
    }

    public boolean validatePhone(String phone) {
        return !userRepository.findByPhone(phone).isPresent();
    }


    /**
     * @Author Tan Mingyao
     * @Description
     * @LastModified 20:31 2020/9/10
     * @Param [userRLDTO]
     * @Return java.lang.String
     **/
    public String register(UserRLDTO userRLDTO) {
        String msg = "";
        if (!userRLDTO.getMail().isEmpty() && validateMail(userRLDTO.getMail())) {
            User user = new User();
            user.setPassword(userRLDTO.getPassword());
            user.setMail(userRLDTO.getMail());
            user.setUsername(userRLDTO.getUsername());
            user.setCreateTime(new Timestamp(System.currentTimeMillis()));
            user.setLastLogin(new Timestamp(System.currentTimeMillis()));
            user.setExp(60);
            user.setSecrecy((byte) 0);
            user.setActivate((byte) 1);
            userRepository.save(user);
            msg = "reg by mail";
        } else if (!userRLDTO.getPhone().isEmpty() && validatePhone(userRLDTO.getPhone())) {
            User user = new User();
            user.setPassword(userRLDTO.getPassword());
            user.setPhone(userRLDTO.getPhone());
            userRepository.save(user);
            msg = "reg by phone";
        }else {
            msg = "existed!";
        }
        return msg;
    }

    /**
     * @Author Tan Mingyao
     * @Description
     * @LastModified 13:23 2020/9/9
     * @Param [userLoginDTO]
     * @Return java.lang.String
     **/
    public User login(UserRLDTO userLoginDTO) {
        String msg = "";
        User user = new User();
        if (!userLoginDTO.getPhone().isEmpty()) {
            Optional<User> userOptional = userRepository.findByPhone(userLoginDTO.getPhone());
            user = userOptional.orElse(null);

        } else if (!userLoginDTO.getMail().isEmpty()) {
            Optional<User> userOptional = userRepository.findByMail(userLoginDTO.getMail());
            user = userOptional.orElse(null);
        }

        assert user != null;
        if (user.getPassword().equals(userLoginDTO.getPassword())) {
            user.setPassword(null);
            msg = "ok";
        } else {
            return null;
        }
        return user;
    }

    /**
     * @Author Tan Mingyao
     * @Description
     * @LastModified 18:20 2020/9/9
     * @Param [id, userInfoDTO]
     * @Return java.lang.String
     **/
    public String changeUserInfo(Long id, UserInfoDTO userInfoDTO) {
        String msg = "";
        User user = new User();
        user.setId(id);
        user.setUsername(userInfoDTO.getUsername());
        user.setSecrecy(userInfoDTO.getSecrecy());
        user.setPassword(userInfoDTO.getPassword());
        user.setAvatar(userInfoDTO.getAvatar());
        user.setBirth(userInfoDTO.getBirth());
        user.setLocation(userInfoDTO.getLocation());
        user.setMajor(userInfoDTO.getMajor());
        user.setMotto(userInfoDTO.getMotto());
        user.setQq(userInfoDTO.getQq());
        user.setSex(userInfoDTO.getSex());
        user.setSno(userInfoDTO.getSno());

        userRepository.save(user);
        msg = "changed!";
        return msg;
    }
}
