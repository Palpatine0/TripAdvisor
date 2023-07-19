package com.example.tripadvisor.controller.frontdesk;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tripadvisor.pojo.Category;
import com.example.tripadvisor.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/frontdesk/category")
public class CategoryControllerFD {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/all")
    @ResponseBody
    public List<Category> all(){
        return categoryService.findAll();
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
