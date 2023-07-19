package com.example.tripadvisor.controller.frontdesk;

import com.example.tripadvisor.bean.Result;
import com.example.tripadvisor.bean.WEditorResult;
import com.example.tripadvisor.pojo.Category;
import com.example.tripadvisor.pojo.Member;
import com.example.tripadvisor.pojo.Product;
import com.example.tripadvisor.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxProperties;
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
import java.util.UUID;

@Controller
@RequestMapping("/frontdesk/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping("/register")
    public ModelAndView register(Member member, String checkCode, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        // Check the checkCode
        // Page code
        String sessionCheckCode = (String) session.getAttribute("checkCode");
        if (sessionCheckCode != null && checkCode != null && !sessionCheckCode.equalsIgnoreCase(checkCode)) {
            modelAndView.addObject("message", "Incorrect verify code");
            modelAndView.setViewName("/frontdesk/register");
            return modelAndView;
        }

        // Register
        Result result = memberService.register(member);
        if (!result.isFlag()) {
            modelAndView.addObject("message", result.getMessage());
            modelAndView.setViewName("/frontdesk/register");
        } else {
            //memberService.incrementScoreByMemberId(member,50);
            modelAndView.setViewName("/frontdesk/register_Sdone");
        }


        return modelAndView;
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

    @RequestMapping("/login")
    public ModelAndView login(String username,String password,HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        Result result = memberService.login(username, password);
        if (!result.isFlag()){
            modelAndView.addObject("message",result.getMessage());
            modelAndView.setViewName("redirect:/frontdesk/login");
        }else {
            session.setAttribute("member",result.getData());
            modelAndView.setViewName("redirect:/frontdesk/index");
        }
        return modelAndView;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("member");
        return "redirect:/frontdesk/index";
    }


    @RequestMapping("/edit")
    public ModelAndView edit(Integer mid){
        Member member = memberService.findById(mid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("member",member);
        modelAndView.setViewName("/frontdesk/profile_edit");
        return modelAndView;
    }


    @RequestMapping("/update")
    public String update(Member mid,HttpSession session){
        memberService.update(mid);
        Member member = memberService.findById(mid.getMid());
        session.setAttribute("member",member);
        return "redirect:/frontdesk/profile/myProfile";
    }

}

