package com.example.tripadvisor;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tripadvisor.bean.RoleWithStatus;
import com.example.tripadvisor.mapper.AdminMapper;
import com.example.tripadvisor.mapper.ProductMapper;
import com.example.tripadvisor.pojo.Admin;
import com.example.tripadvisor.pojo.Product;
import com.example.tripadvisor.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TripAdvisorApplicationTests {

    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private ProductMapper productMapper;

    @Test
    void contextLoads() {
        /*Page<Admin> page = adminService.findPage(1, 5);
        System.out.println(page);*/
        /*Admin desc = adminMapper.findDesc(1);
        System.out.println(desc);*/
        /*List<RoleWithStatus> role = adminService.findRole(1);
        System.out.println(role);*/
        Page<Product> productPage = productMapper.findProductPage(new Page<>(1, 5));
        System.out.println(productPage);
    }

}
