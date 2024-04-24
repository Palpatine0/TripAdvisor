package com.example.tripadvisor.controller.backstage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tripadvisor.pojo.Category;
import com.example.tripadvisor.pojo.Comments;
import com.example.tripadvisor.pojo.Permission;
import com.example.tripadvisor.pojo.Product;
import com.example.tripadvisor.service.CategoryService;
import com.example.tripadvisor.service.CommentsService;
import com.example.tripadvisor.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/backstage/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CommentsService commentsService;

    @RequestMapping("/all")
    public ModelAndView all(@RequestParam(defaultValue = "1") int page,
                            @RequestParam(defaultValue = "15") int size){

        ModelAndView modelAndView = new ModelAndView();
        Page<Product> productPage = productService.findPage(page, size);
        modelAndView.addObject("productPage",productPage);
        modelAndView.setViewName("/backstage/product_all");

        return modelAndView;
    }


    @RequestMapping("/addPage")
    public ModelAndView add(){
        List<Category> categoryList = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("categoryList",categoryList);
        modelAndView.setViewName("/backstage/product_add");
        return modelAndView;
    }
    @RequestMapping("/add")
    public String add(Product pid){
        productService.add(pid);
        return "redirect:/backstage/product/all";
    }


    @RequestMapping("/upload")
    @ResponseBody
    public String uploadImage(HttpServletRequest request, @RequestParam("file") MultipartFile imageFile) {
        String imageUrl = null;
        if (!imageFile.isEmpty()) {
            try {
                String realPath = ResourceUtils.getURL("classpath:").getPath() + "/static/upload";
                File dir = new File(realPath);
                if (!dir.exists()) {
                    dir.mkdir();
                }
                String filename = imageFile.getOriginalFilename();
                filename = UUID.randomUUID() + filename;
                File newFile = new File(dir, filename);
                imageFile.transferTo(newFile);
                imageUrl = "/upload/" + filename;
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the exception as per your requirement
            }
        }
        return imageUrl;
    }

    @RequestMapping("/edit")
    public ModelAndView edit(Integer pid){
        Product product = productService.findById(pid);
        List<Category> categoryList = categoryService.findAll();
        List<Comments> comments = commentsService.findByPid(pid);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product",product);
        modelAndView.addObject("comments",comments);
        modelAndView.addObject("categoryList",categoryList);
        modelAndView.setViewName("/backstage/product_edit");
        return modelAndView;
    }
    @RequestMapping("/update")
    public String update(Product pid){
        productService.update(pid);
        return "redirect:/backstage/product/all";
    }

    @RequestMapping("/updateStatus")
    public String updateStatus(Integer pid,@RequestHeader("Referer") String referer){
        productService.updateStatus(pid);
        return "redirect:"+referer;
    }

    @RequestMapping("/delete")
    public String delete(Product pid){
        productService.delete(pid);
        return "redirect:/backstage/product/all";
    }

}
