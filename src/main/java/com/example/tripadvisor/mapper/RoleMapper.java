package com.example.tripadvisor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.tripadvisor.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {
    List<Integer> findRoleIdByAdmin(Integer id);

    void deleteAllPermissions(Integer aid);
    void addPermission(@Param("rid")Integer aid, @Param("pid")Integer rid);
}
