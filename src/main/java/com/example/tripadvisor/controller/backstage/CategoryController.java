package com.example.tripadvisor.controller.backstage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tripadvisor.pojo.Category;
import com.example.tripadvisor.pojo.Permission;
import com.example.tripadvisor.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/backstage/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/all")
    public ModelAndView all(@RequestParam(defaultValue = "1") int page,
                            @RequestParam(defaultValue = "10") int size){
        ModelAndView modelAndView = new ModelAndView();
        Page<Category> categoryPage = categoryService.findPage(page, size);
        modelAndView.addObject("categoryPage",categoryPage);
        modelAndView.setViewName("/backstage/category_all");
        return modelAndView;
    }

    @RequestMapping("/add")
    public String add(Category cid){
        categoryService.add(cid);
        return "redirect:/backstage/category/all";
    }

    @RequestMapping("/edit")
    public ModelAndView edit(Integer cid){
        Category category = categoryService.findById(cid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("category",category);
        modelAndView.setViewName("/backstage/category_edit");
        return modelAndView;
    }
    @RequestMapping("/update")
    public String update(Category cid){
        categoryService.update(cid);
        return "redirect:/backstage/category/all";
    }

    @RequestMapping("/delete")
    public String delete(Category cid){
        categoryService.delete(cid);
        return "redirect:/backstage/category/all";
    }

}
