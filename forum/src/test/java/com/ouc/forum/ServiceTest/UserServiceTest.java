package com.ouc.forum.ServiceTest;

import com.ouc.forum.DTO.UserRLDTO;
import com.ouc.forum.entity.User;
import com.ouc.forum.repository.UserRepository;
import com.ouc.forum.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author fxjy
 * @Date 2020/9/9 18:52
 * @Version 1.0
 */
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Test
    void registerTest() {
        UserRLDTO userRLDTO = new UserRLDTO();
        userRLDTO.setMail("23424334");
        userRLDTO.setPhone("");
        userRLDTO.setPassword("3243423");
        userRLDTO.setUsername("小敏");
        System.out.println(userService.register(userRLDTO));
    }

    @Test
    void loginTest() {
        UserRLDTO userRLDTO = new UserRLDTO();
        userRLDTO.setMail("23424334");
        userRLDTO.setPhone("");
        userRLDTO.setPassword("3243423");
        System.out.println(userService.login(userRLDTO));
    }

    @Test
    void Test() {
        User user = new User();
        user.setMail("111");
        user.setUsername("str");
        user.setPassword("1111");
        userRepository.save(user);
    }

}
