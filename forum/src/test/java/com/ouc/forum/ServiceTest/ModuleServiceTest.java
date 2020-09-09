package com.ouc.forum.ServiceTest;

import com.ouc.forum.entity.Module;
import com.ouc.forum.service.ModuleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author fxjy
 * @Date 2020/9/9 19:50
 * @Version 1.0
 */
@SpringBootTest
public class ModuleServiceTest {
    @Autowired
    private ModuleService moduleService;

    @Test
    public void getAllTest(){
        List<Module> moduleList = moduleService.getAll();
        for (Module m:moduleList) {
            System.out.println(m);
        }
    }

    @Test
    public void get(){
        System.out.println(moduleService.get((long) 1));
    }

}
