package com.ouc.forum.controller;

import com.ouc.forum.DTO.ModuleDTO;
import com.ouc.forum.entity.Module;
import com.ouc.forum.entity.Tie;
import com.ouc.forum.service.ModuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author fxjy
 * @Date 2020/9/9 13:14
 * @Version 1.0
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/module")
@Api(value = "版块", tags = "版块接口")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    @GetMapping(value = "", produces = "application/json")
    @ApiOperation(value = "所有版块", notes = "查询所有版块")
    public List<Module> getAll() {
        return moduleService.getAll();
    }

    @GetMapping(value = "/{mid}", produces = "application/json")
    @ApiOperation(value = "单个版块", notes = "查询单个版块")
    public ModuleDTO get(@ApiParam(value = "版块ID", required = true) @PathVariable Long mid) {
        return moduleService.get(mid);
    }

    @GetMapping(value = "/tie/{mid}/{pageNum}", produces = "application/json")
    @ApiOperation(value = "版块帖子展示", notes = "查询某版块下所有帖子")
    public List<Tie> getTieByPage(@ApiParam(value = "版块ID", required = true) @PathVariable Long mid, @ApiParam(value = "页数", required = true) @PathVariable int pageNum) {
        return moduleService.getTieByPage(mid, pageNum);
    }

}
