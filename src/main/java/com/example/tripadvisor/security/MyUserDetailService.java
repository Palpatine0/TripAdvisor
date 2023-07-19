package com.example.tripadvisor.security;

import com.example.tripadvisor.pojo.Admin;
import com.example.tripadvisor.pojo.Permission;
import com.example.tripadvisor.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private AdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //1. authenticate
        Admin admin = adminService.findByAdminName(username);
        if (admin==null){
            throw new UsernameNotFoundException("user doesnt exist");
        }
        if (!admin.isStatus()){
            throw new UsernameNotFoundException("user unavailable");
        }

        //2. authorize
        List<Permission> permissions = adminService.findAllPermission(username);
        //convert permission to what spring security can identify
        List<GrantedAuthority> grantedAuthorities = new ArrayList();
        for (Permission permission : permissions) {
            grantedAuthorities.add(new SimpleGrantedAuthority(permission.getPermissionDesc()));
        }
        
        UserDetails userDetails = User.withUsername(admin.getUsername())
                .password(admin.getPassword())
                .authorities(grantedAuthorities)
                .build();
        return userDetails;
    }
}
