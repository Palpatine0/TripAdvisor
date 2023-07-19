package com.example.tripadvisor.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tripadvisor.mapper.PermissionMapper;
import com.example.tripadvisor.pojo.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    public Page<Permission> findPage(int page, int size){
        Page selectPage = permissionMapper.selectPage(new Page(page,size),null);
        return selectPage;
    }

    public void add(Permission pid){
        permissionMapper.insert(pid);
    }

    public Permission findById(Integer id){
        return permissionMapper.selectById(id);
    }
    public void update(Permission pid){
        permissionMapper.updateById(pid);
    }

    public void delete(Permission pid){
        permissionMapper.deleteById(pid);
    }
}
