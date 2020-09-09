package com.ouc.forum.controller;

import com.ouc.forum.DTO.UserInfoDTO;
import com.ouc.forum.DTO.UserRLDTO;
import com.ouc.forum.entity.User;
import com.ouc.forum.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author fxjy
 * @Date 2020/9/9 21:19
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户", tags = "用户接口")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户注册", notes = "学生输入信息注册")
    @PostMapping(value = "/register", produces = "application/json")
    public String register(@RequestBody UserRLDTO userRegDTO) {
        return userService.register(userRegDTO);
    }

    @ApiOperation(value = "用户登录", notes = "登录成功后用户信息回填")
    @PostMapping(value = "/login", produces = "application/json")
    public User login(@RequestBody UserRLDTO userLoginDTO) {
        return userService.login(userLoginDTO);
    }

    @ApiOperation(value = "修改信息", notes = "更改个人中心处的信息")
    @PostMapping(value = "/{id}", produces = "application/json")
    public String changeUserInfo(@PathVariable Long id, UserInfoDTO userInfoDTO) {
        return userService.changeUserInfo(id, userInfoDTO);
    }
}
