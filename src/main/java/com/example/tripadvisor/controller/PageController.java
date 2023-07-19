package com.example.tripadvisor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    //bake stage
    @RequestMapping("/backstage/{page}")
    //@PathVariable: get ele "{page}" from url,pages belongs to /bakestage/ will load in ele space after this annotation
    public String showBackStage(@PathVariable String page){
        return "/backstage/"+page;
    }

    //front desk
    @RequestMapping("/frontdesk/{page}")
    public String showFrontDesk(@PathVariable String page){
        return "/frontdesk/"+page;
    }
}
