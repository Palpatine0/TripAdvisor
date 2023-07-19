package com.example.tripadvisor.controller.frontdesk;

import com.example.tripadvisor.pojo.Member;
import com.example.tripadvisor.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/frontdesk/profile")
public class ProfileController {
    @Autowired
    private MemberService memberService;


    @GetMapping("/myProfile")
    public ModelAndView viewProfile(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        Member member = (Member) session.getAttribute("member");
        Member updatedMember = memberService.findById(member.getMid());
        modelAndView.addObject("member", updatedMember);
        modelAndView.setViewName("/frontdesk/profile");
        return modelAndView;
    }



}
