package com.example.tripadvisor.controller.frontdesk;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tripadvisor.pojo.Comments;
import com.example.tripadvisor.pojo.Member;
import com.example.tripadvisor.pojo.Permission;
import com.example.tripadvisor.pojo.Product;
import com.example.tripadvisor.service.CommentsService;
import com.example.tripadvisor.service.MemberService;
import com.example.tripadvisor.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/frontdesk/comments")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/add")
    public ModelAndView add(@ModelAttribute("comment") Comments comment, HttpSession session, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        Member member = (Member) session.getAttribute("member");

        comment.setMid(member.getMid());
        comment.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        String remoteAddr = request.getRemoteAddr();
        comment.setRemoteAddr(remoteAddr);

        commentsService.add(comment);

        modelAndView.setViewName("redirect:/frontdesk/product/routeDetails?pid=" + comment.getPid());
        return modelAndView;
    }

    @RequestMapping("/delete")
    public String delete(Comments cid){
        commentsService.delete(cid);
        return "redirect:/backstage/product/all";
    }


}