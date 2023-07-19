package com.example.tripadvisor.controller.frontdesk;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tripadvisor.pojo.Member;
import com.example.tripadvisor.pojo.Product;
import com.example.tripadvisor.service.FavoriteService;
import com.example.tripadvisor.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/frontdesk/favorite")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;
    @Autowired
    private MemberService memberService;

    @RequestMapping("/add")
    public String add(Integer pid, HttpSession session, @RequestHeader("Referer")String referer){
        Member member = (Member)session.getAttribute("member");
        favoriteService.addFavorite(pid,member.getMid());
        memberService.incrementScoreByMemberId(member,2);
        return "redirect:"+referer;
    }
    @RequestMapping("/del")
    public String del(Integer pid, HttpSession session, @RequestHeader("Referer")String referer){
        Member member = (Member)session.getAttribute("member");
        favoriteService.delFavorite(pid,member.getMid());
        return "redirect:"+referer;
    }

    @RequestMapping("/myFavorite")
    public ModelAndView myFavorite(@RequestParam(defaultValue = "1") int page,
                                   @RequestParam(defaultValue = "15") int size,HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        Member member = (Member) session.getAttribute("member");
        Page<Product> productPage = favoriteService.findMemberFavoritePage(page, size, member.getMid());
        modelAndView.addObject("productPage",productPage);
        modelAndView.setViewName("/frontdesk/my_favorite");
        return modelAndView;
        
    }


}
