package com.example.tripadvisor.controller.backstage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tripadvisor.pojo.Member;
import com.example.tripadvisor.pojo.Role;
import com.example.tripadvisor.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/backstage/memberB")
public class MemberControllerBE {
    @Autowired
    private MemberService memberService;


    @PreAuthorize("hasAnyAuthority('/memberB/RA')")
    @RequestMapping("/RA")
    public ModelAndView all(@RequestParam(defaultValue = "1") int page,
                            @RequestParam(defaultValue = "100") int size){
        ModelAndView modelAndView = new ModelAndView();
        Member member = new Member();
        Page<Member> memberPage = memberService.findPage(page, size);
        modelAndView.addObject("memberPage",memberPage);
        modelAndView.setViewName("/backstage/member_all");
        return modelAndView;
    }

    @PreAuthorize("hasAnyAuthority('/memberB/RB')")
    @RequestMapping("/allRB")
    public ModelAndView allRB(@RequestParam(defaultValue = "1") int page,
                            @RequestParam(defaultValue = "100") int size){
        ModelAndView modelAndView = new ModelAndView();
        Member member = new Member();
        Page<Member> memberPage = memberService.findPage(page, size);
        modelAndView.addObject("memberPage",memberPage);
        modelAndView.setViewName("/backstage/member_allRB");
        return modelAndView;
    }
    @PreAuthorize("hasAnyAuthority('/memberB/RC')")
    @RequestMapping("/allRC")
    public ModelAndView allRC(@RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "100") int size){
        ModelAndView modelAndView = new ModelAndView();
        Member member = new Member();
        Page<Member> memberPage = memberService.findPage(page, size);
        modelAndView.addObject("memberPage",memberPage);
        modelAndView.setViewName("/backstage/member_allRC");
        return modelAndView;
    }
    @PreAuthorize("hasAnyAuthority('/memberB/RD')")
    @RequestMapping("/allRD")
    public ModelAndView allRD(@RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "100") int size){
        ModelAndView modelAndView = new ModelAndView();
        Member member = new Member();
        Page<Member> memberPage = memberService.findPage(page, size);
        modelAndView.addObject("memberPage",memberPage);
        modelAndView.setViewName("/backstage/member_allRD");
        return modelAndView;
    }
    @PreAuthorize("hasAnyAuthority('/memberB/RE')")
    @RequestMapping("/allRE")
    public ModelAndView allRE(@RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "100") int size){
        ModelAndView modelAndView = new ModelAndView();
        Member member = new Member();
        Page<Member> memberPage = memberService.findPage(page, size);
        modelAndView.addObject("memberPage",memberPage);
        modelAndView.setViewName("/backstage/member_allRE");
        return modelAndView;
    }
    @PreAuthorize("hasAnyAuthority('/memberB/RF')")
    @RequestMapping("/allRF")
    public ModelAndView allRF(@RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "100") int size){
        ModelAndView modelAndView = new ModelAndView();
        Member member = new Member();
        Page<Member> memberPage = memberService.findPage(page, size);
        modelAndView.addObject("memberPage",memberPage);
        modelAndView.setViewName("/backstage/member_allRF");
        return modelAndView;
    }

    @RequestMapping("/edit")
    public ModelAndView edit(Integer mid){
        Member member = memberService.findById(mid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("member",member);
        modelAndView.setViewName("/backstage/member_edit");
        return modelAndView;
    }

    @RequestMapping("/update")
    public String update(Member member, HttpServletRequest request, HttpSession session){
        memberService.update(member);

        // Store the previous page URL in a session attribute
        String referer = request.getHeader("Referer");
        session.setAttribute("previousPage", referer);
        return "redirect:/backstage/index";
    }



}
