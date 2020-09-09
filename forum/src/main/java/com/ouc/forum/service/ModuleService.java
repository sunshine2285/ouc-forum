package com.ouc.forum.service;

import com.ouc.forum.entity.Module;
import com.ouc.forum.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author fxjy
 * @Date 2020/9/9 13:17
 * @Version 1.0
 */
@Service
public class ModuleService {
    @Autowired
    private ModuleRepository moduleRepository;

    public List<Module> getAll() {
        return moduleRepository.findAll();
    }

    public Module get(Long id) {
        Optional<Module> module = moduleRepository.findById(id);
        return module.orElse(new Module());
    }
}
