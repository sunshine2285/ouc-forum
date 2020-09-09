package com.ouc.forum.controller;

import com.ouc.forum.entity.Module;
import com.ouc.forum.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author fxjy
 * @Date 2020/9/9 13:14
 * @Version 1.0
 */
@RestController
@RequestMapping("/module")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    @GetMapping("/")
    public List<Module> getAll(){
        return moduleService.getAll();
    }

    @GetMapping("/{id}")
    public Module get(@PathVariable Long id){
        return moduleService.get(id);
    }

}
