package com.example.tripadvisor.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tripadvisor.bean.PermissionWithStatus;
import com.example.tripadvisor.mapper.PermissionMapper;
import com.example.tripadvisor.mapper.RoleMapper;
import com.example.tripadvisor.pojo.Permission;
import com.example.tripadvisor.pojo.Role;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;


    //page sort
    public Page<Role> findPage(int page, int size){
        Page selectPage = roleMapper.selectPage(new Page(page,size),null);
        return selectPage;
    }

    public void add(Role rid){
        roleMapper.insert(rid);
    }

    //role update
    public Role findById(Integer id){
        return roleMapper.selectById(id);
    }
    public void update(Role rid){
        roleMapper.updateById(rid);
    }

    public void delete(Role rid){
        roleMapper.deleteById(rid);
    }


    //search role's permission id
    public List<PermissionWithStatus> findPermission(Integer rid){
        List<Integer> pids = permissionMapper.findPermissionIdByRole(rid);
        List<Permission> permissions = permissionMapper.selectList(null);
        List<PermissionWithStatus> permissionList = new ArrayList();

        for (Permission permission : permissions) {
            PermissionWithStatus permissionWithStatus = new PermissionWithStatus();
            BeanUtils.copyProperties(permission,permissionWithStatus);
            if (pids.contains(permission.getPid())){
                permissionWithStatus.setRoleHas(true);
            }else {
                permissionWithStatus.setRoleHas(false);
            }
            permissionList.add(permissionWithStatus);
        }
        return permissionList;
    }

    //update permissions
    public void updatePermission(Integer rid,Integer[] pids){
        roleMapper.deleteAllPermissions(rid);
        for (Integer pid : pids) {
            roleMapper.addPermission(rid,pid);
        }
    }

    /*
    //update status
    public void updateStatus(Integer aid){
        Admin admin = adminMapper.selectById(aid);
        admin.setStatus(!admin.isStatus());
        adminMapper.updateById(admin);
    }*/
}
