package com.example.tripadvisor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.tripadvisor.pojo.Admin;
import com.example.tripadvisor.pojo.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper extends BaseMapper<Admin> {
    //admin information browse
    Admin findDesc(Integer aid);

    //add roles
    //delete all role admin have
    void deleteAllRoles(Integer aid);
    //reinsert role for admin
    void addRole(@Param("aid")Integer aid,@Param("rid")Integer rid);

    //search permission
    List<Permission> findAllPermission(String name);

}
