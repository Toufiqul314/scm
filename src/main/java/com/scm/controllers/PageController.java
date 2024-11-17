package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/home")
    public String home(Model model){
        System.out.println("home page");
        model.addAttribute("name","Toufiq Technologies");
        model.addAttribute("Youtubechannel","learn code toufiqul");
        return "home";
    }

    // about page
    @GetMapping("/about")
    public String aboutPage(Model model){
        model.addAttribute("isLogin",true);
        return "about";
    }

    // services page
    @GetMapping("/services")
    public String servicesPage(Model model){
        return "services";
    }

    // contact page
    @GetMapping("/contact")
    public String contactPage(){
        return "contact";
    }

    //login page
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    //register page
    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }
}
