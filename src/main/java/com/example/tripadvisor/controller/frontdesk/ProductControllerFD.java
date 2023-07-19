package com.example.tripadvisor.controller.frontdesk;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tripadvisor.bean.WEditorResult;
import com.example.tripadvisor.pojo.Category;
import com.example.tripadvisor.pojo.Comments;
import com.example.tripadvisor.pojo.Member;
import com.example.tripadvisor.pojo.Product;
import com.example.tripadvisor.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/frontdesk/product")
public class ProductControllerFD {
    @Autowired
    private ProductService productService;
    @Autowired
    private FavoriteService favoriteService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private CommentsService commentsService;

    @RequestMapping("/routeList")
    public ModelAndView findProduct(Integer cid,String productName,
                                    @RequestParam(defaultValue = "1") int page,
                                    @RequestParam(defaultValue = "15") int size){
        ModelAndView modelAndView = new ModelAndView();
        Page<Product> productPage = productService.findProduct(cid, productName, page, size);
        modelAndView.addObject("productPage",productPage);
        modelAndView.addObject("cid",cid);
        modelAndView.addObject("productName",productName);
        modelAndView.setViewName("/frontdesk/route_list");
        return modelAndView;
    }

    @RequestMapping("/routeListIndexed")
    public ModelAndView findProductIndexed(Integer cid,String productName,
                                    @RequestParam(defaultValue = "1") int page,
                                    @RequestParam(defaultValue = "15") int size){
        ModelAndView modelAndView = new ModelAndView();
        Page<Product> productPage = productService.findProduct(cid, productName, page, size);
        modelAndView.addObject("productPage",productPage);
        modelAndView.addObject("cid",cid);
        modelAndView.addObject("productName",productName);
        modelAndView.setViewName("/frontdesk/route_list");
        return modelAndView;
    }

    @RequestMapping("/routeDetails")
    public ModelAndView findDeatails(Integer pid, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.findById(pid);
        List<Comments> comments = commentsService.findByPid(pid);

        //favorite judge
        //cant favorite if not in login status
        Object member = session.getAttribute("member");
        if (member==null){
            modelAndView.addObject("favorite",false);
        }else {
            Member memberr=(Member)member;
            boolean favorite = favoriteService.findFavorite(pid, memberr.getMid());
            modelAndView.addObject("favorite",favorite);
        }

        modelAndView.addObject("product",product);
        modelAndView.addObject("comments",comments);
        modelAndView.setViewName("/frontdesk/route_detail");
        return modelAndView;
    }

    @RequestMapping("/addPage")
    public ModelAndView add(){
        List<Category> categoryList = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("categoryList",categoryList);
        modelAndView.setViewName("/frontdesk/FFFproduct_add");
        return modelAndView;
    }

    @RequestMapping("/add")
    public String add(Product pid,HttpSession session){

        Member member=(Member)session.getAttribute("member");

        int submissionLimit=0;
        if (member.getScore() < 200) {
            submissionLimit = 1;
        } else if(member.getScore() < 400) {
            submissionLimit = 5;
        }else {
            submissionLimit = Integer.MAX_VALUE;
        }

        LocalDate currentDate = LocalDate.now();

        if (submissionLimit > 0 && memberService.getSubmissionCountByMemberAndDate(member, currentDate) >= submissionLimit) {
            return "redirect:/frontdesk/limit_reached.html";
        }

        productService.add(pid);
        memberService.incrementScoreByMemberId(member,10);

        return "redirect:/frontdesk/index.html";
    }

    @ResponseBody
    @RequestMapping("/upload")
    public WEditorResult upLoad(HttpServletRequest request, MultipartFile file) throws IOException {
        // 1.create the file pack and save uploaded file
        // 1.1 real file path
        String realPath = ResourceUtils.getURL("classpath:").getPath() + "/static/upload";
        // 1.2 check if the pack exist, create one if its not
        File dir = new File(realPath);
        if (!dir.exists()){
            dir.mkdir();
        }
        // 2.get the upload file name
        String filename = file.getOriginalFilename();
        filename= UUID.randomUUID()+filename;
        // 3.create empty file
        File newFile = new File(dir, filename);
        // 4.upload file to this empty file
        file.transferTo(newFile);
        // 5.construct result type
        WEditorResult wEditorResult = new WEditorResult();
        wEditorResult.setErrno(0);
        String[] data={"/upload/"+filename};
        wEditorResult.setData(data);
        return wEditorResult;
    }
}
