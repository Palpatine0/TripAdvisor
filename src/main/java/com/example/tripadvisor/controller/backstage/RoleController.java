package com.example.tripadvisor.controller.backstage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tripadvisor.bean.PermissionWithStatus;
import com.example.tripadvisor.bean.RoleWithStatus;
import com.example.tripadvisor.pojo.Admin;
import com.example.tripadvisor.pojo.Role;
import com.example.tripadvisor.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/backstage/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PreAuthorize("hasAnyAuthority('/role/all')")
    @RequestMapping("/all")
    public ModelAndView all(@RequestParam(defaultValue = "1") int page,
                            @RequestParam(defaultValue = "10") int size){
        ModelAndView modelAndView = new ModelAndView();
        Page<Role> rolePage = roleService.findPage(page, size);
        modelAndView.addObject("rolePage",rolePage);
        modelAndView.setViewName("/backstage/role_all");
        return modelAndView;
    }

    @RequestMapping("/add")
    public String add(Role rid){
        roleService.add(rid);
        return "redirect:/backstage/role/all";
    }


    @RequestMapping("/edit")
    public ModelAndView edit(Integer rid){
        Role role = roleService.findById(rid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("role",role);
        modelAndView.setViewName("/backstage/role_edit");
        return modelAndView;
    }
    @RequestMapping("/update")
    public String update(Role rid){
        roleService.update(rid);
        return "redirect:/backstage/role/all";
    }

    @RequestMapping("/delete")
    public String delete(Role rid){
        roleService.delete(rid);
        return "redirect:/backstage/role/all";
    }


    @RequestMapping("/findPermission")
    public ModelAndView findPermission(Integer rid){
        List<PermissionWithStatus> permissions = roleService.findPermission(rid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("permissions",permissions);
        modelAndView.addObject("rid",rid);
        modelAndView.setViewName("/backstage/role_permissions");
        return modelAndView;
    }

    @RequestMapping("/updatePermission")
    public String updatePermission(Integer rid,Integer[] ids){
        roleService.updatePermission(rid,ids);
        return "redirect:/backstage/role/all";
    }

}
