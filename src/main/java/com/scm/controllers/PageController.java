package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("home page");
        model.addAttribute("name","Toufiq Technologies");
        model.addAttribute("Youtubechannel","learn code toufiqul");
        return "home";
    }
}
