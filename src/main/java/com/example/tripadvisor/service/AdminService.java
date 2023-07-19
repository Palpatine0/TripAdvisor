package com.example.tripadvisor.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tripadvisor.bean.RoleWithStatus;
import com.example.tripadvisor.mapper.AdminMapper;
import com.example.tripadvisor.mapper.RoleMapper;
import com.example.tripadvisor.pojo.Admin;
import com.example.tripadvisor.pojo.Permission;
import com.example.tripadvisor.pojo.Role;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    BCryptPasswordEncoder encoder;

    //page sort
    public Page<Admin> findPage(int page,int size){
        Page selectPage = adminMapper.selectPage(new Page(page,size),null);
        return selectPage;
    }

    //insert
    public void add(Admin admin){
        admin.setPassword(encoder.encode(admin.getPassword()));
        adminMapper.insert(admin);
    }

    //admin update
    //id query
    public Admin findById(Integer id){
        return adminMapper.selectById(id);
    }
    //update when id is got and info is filled
    public void update(Admin admin){
        String oldPassword = adminMapper.selectById(admin.getAid()).getPassword();
        String newPassword = admin.getPassword();
        if (oldPassword != newPassword) {
            admin.setPassword(encoder.encode(admin.getPassword()));
        }
        adminMapper.updateById(admin);
    }

    //admin info search
    public Admin findDesc(Integer aid){
        return adminMapper.findDesc(aid);
    }

    //search admin's role id
    public List<RoleWithStatus> findRole(Integer aid){
        //1. search all role the admin have
        List<Integer> rids = roleMapper.findRoleIdByAdmin(aid);
        //2. search all role
        List<Role> roles = roleMapper.selectList(null);
        //3. create a list with RoleWithStatus
        List<RoleWithStatus> roleList = new ArrayList();

        //4. check role status,T/F
        for (Role role:roles){
            //create role with status
            RoleWithStatus roleWithStatus = new RoleWithStatus();
            //copy roles's properties to object rolesWithStatus
            BeanUtils.copyProperties(role,roleWithStatus);
            if(rids.contains(role.getRid())){
                //mark status as T if the id exist
                roleWithStatus.setAdminHas(true);
            }else { //otherwise
                roleWithStatus.setAdminHas(false);
            }
            roleList.add(roleWithStatus);
        }
        return roleList;
    }

    //update roles
    public void updateRole(Integer aid,Integer[] rids){
        //1. delete all role admin have
        adminMapper.deleteAllRoles(aid);
        //2. reinsert roles for admin
        for (Integer rid : rids) {
            adminMapper.addRole(aid,rid);
        }
    }

    //update status
    public void updateStatus(Integer aid){
        Admin admin = adminMapper.selectById(aid);
        admin.setStatus(!admin.isStatus());
        adminMapper.updateById(admin);
    }


    public Admin findByAdminName(String username) {
        QueryWrapper<Admin> wrapper = new QueryWrapper();
        //success when the element and username col in DB equals
        wrapper.eq("username", username);
        Admin admin = adminMapper.selectOne(wrapper);
        return admin;
    }

    public List<Permission> findAllPermission(String username){
        return adminMapper.findAllPermission(username);
    }

}
