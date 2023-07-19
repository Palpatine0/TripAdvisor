package com.example.tripadvisor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.tripadvisor.pojo.Permission;

import java.util.List;

public interface PermissionMapper extends BaseMapper<Permission> {
    List<Integer> findPermissionIdByRole(Integer id);


}
