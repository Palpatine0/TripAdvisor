package com.example.tripadvisor.controller.backstage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tripadvisor.bean.RoleWithStatus;
import com.example.tripadvisor.pojo.Admin;
import com.example.tripadvisor.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/backstage/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PreAuthorize("hasAnyAuthzority('/admin/all')")
    @RequestMapping("/all")
    public ModelAndView all(@RequestParam(defaultValue = "1") int page,
                            @RequestParam(defaultValue = "10") int size){
        ModelAndView modelAndView = new ModelAndView();
        Page<Admin> adminPage = adminService.findPage(page, size);
        modelAndView.addObject("adminPage",adminPage);
        modelAndView.setViewName("/backstage/admin_all");
        return modelAndView;
    }

    @RequestMapping("/add")
    public String add(Admin admin){
        adminService.add(admin);
        return "redirect:/backstage/admin/all";
    }

    //query admin and redirect to edit page
    @RequestMapping("/edit")
    public ModelAndView edit(Integer aid){
        Admin admin = adminService.findById(aid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("admin",admin);
        modelAndView.setViewName("/backstage/admin_edit");
        return modelAndView;
    }
    @RequestMapping("/update")
    public String update(Admin admin){
        adminService.update(admin);
        return "redirect:/backstage/admin/all";
    }

    @RequestMapping("/desc")
    public ModelAndView desc(Integer aid){
        Admin admin = adminService.findDesc(aid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("admin",admin);
        modelAndView.setViewName("/backstage/admin_desc");
        return modelAndView;
    }

    @RequestMapping("/findRole")
    public ModelAndView findRole(Integer aid){
        List<RoleWithStatus> roles = adminService.findRole(aid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("roles",roles);
        modelAndView.addObject("aid",aid);
        modelAndView.setViewName("/backstage/admin_roles");
        return modelAndView;
    }

    @RequestMapping("/updateRole")
    public String updateRole(Integer aid,Integer[] ids){
        adminService.updateRole(aid,ids);
        return "redirect:/backstage/admin/all";
    }

    @RequestMapping("/updateStatus")
    public String updateStatus(Integer aid,@RequestHeader("Referer") String referer){
        adminService.updateStatus(aid);
        return "redirect:"+referer;
    }
}
