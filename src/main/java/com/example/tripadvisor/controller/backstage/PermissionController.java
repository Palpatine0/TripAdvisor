package com.example.tripadvisor.controller.backstage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tripadvisor.pojo.Permission;
import com.example.tripadvisor.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/backstage/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @PreAuthorize("hasAnyAuthority('/permission/all')")
    @RequestMapping("/all")
    public ModelAndView all(@RequestParam(defaultValue = "1") int page,
                            @RequestParam(defaultValue = "10") int size){
        ModelAndView modelAndView = new ModelAndView();
        Page<Permission> permissionPage = permissionService.findPage(page, size);
        modelAndView.addObject("permissionPage",permissionPage);
        modelAndView.setViewName("/backstage/permission_all");
        return modelAndView;
    }

    @PreAuthorize("hasAnyAuthority('/permission/add')")
    @RequestMapping("/add")
    public String add(Permission pid){
        permissionService.add(pid);
        return "redirect:/backstage/permission/all";
    }

    @RequestMapping("/edit")
    public ModelAndView edit(Integer pid){
        Permission permission = permissionService.findById(pid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("permission",permission);
        modelAndView.setViewName("/backstage/permission_edit");
        return modelAndView;
    }
    @RequestMapping("/update")
    public String update(Permission pid){
        permissionService.update(pid);
        return "redirect:/backstage/permission/all";
    }

    @RequestMapping("/delete")
    public String delete(Permission pid){
        permissionService.delete(pid);
        return "redirect:/backstage/permission/all";
    }
}
