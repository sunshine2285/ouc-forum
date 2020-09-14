package com.ouc.forum.service;

import com.ouc.forum.DTO.UserBIDTO;
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
    public int register(UserRLDTO userRLDTO) {
        if (!userRLDTO.getPhone().isEmpty() && validatePhone(userRLDTO.getPhone())) {
            User user = new User();
            user.setPassword(userRLDTO.getPassword());
            user.setPhone(userRLDTO.getPhone());
            user.setUsername(userRLDTO.getUsername());
            user.setCreateTime(new Timestamp(System.currentTimeMillis()));
            user.setLastLogin(new Timestamp(System.currentTimeMillis()));
            user.setExp(60);
            user.setSecrecy((byte) 0);
            user.setActivate((byte) 1);
            user.setAvatar("../assets/avatar.jpg");
            userRepository.save(user);
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * @Author Tan Mingyao
     * @Description
     * @LastModified 13:23 2020/9/9
     * @Param [userLoginDTO]
     * @Return java.lang.String
     **/
    public User login(UserRLDTO userLoginDTO) {
        final User[] user = new User[1];
        user[0] = null;
        if (!userLoginDTO.getPhone().isEmpty()) {
            Optional<User> userOptional = userRepository.findByPhone(userLoginDTO.getPhone());
            userOptional.ifPresent(findUser -> {
                if(findUser.getPassword().equals(userLoginDTO.getPassword())){
                    user[0] = findUser;
                    user[0].setPassword("");
                }
            });
        }
        return user[0];
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
        user.setMail(userInfoDTO.getMail());
        user.setPhone(userInfoDTO.getPhone());
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

    /**
     * @Author Tan Mingyao
     * @Description
     * @LastModified 9:45 2020/9/12
     * @Param [id]
     * @Return com.ouc.forum.DTO.UserBIDTO
     **/
    public UserBIDTO findUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        User user = userOptional.orElse(null);
        if (user == null) {
            return null;
        } else {
            UserBIDTO userBIDTO = new UserBIDTO();
            userBIDTO.setUsername(user.getUsername());
            userBIDTO.setAvatar(user.getAvatar());
            userBIDTO.setMotto(user.getMotto());
            userBIDTO.setSex(user.getSex());
            return userBIDTO;
        }
    }
}
