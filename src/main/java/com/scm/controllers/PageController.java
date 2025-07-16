package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "Spring Boot SCM Application");
        return "home";
    }

    // about page
    @RequestMapping("/about")
    public String aboutPage() {
        return "about";
    }

    // services page
    @RequestMapping("/services")
    public String servicesPage() {
        return "services";
    }
    // contact page
    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }

    // login page
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // register page
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }
}
