package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.forms.UserForm;

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
    public String registerPage(Model model) {
        // default user form object
        UserForm userForm=new UserForm();
        // userForm.setName("toufiqul islam");
        model.addAttribute("userForm", userForm);
        return "register";
    }

    // processing register page
    @RequestMapping(value = "/do-register",method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm){
        System.out.println("Processing Register Form");
        // fetch form data
        // UserForm
        System.out.println(userForm);
        // validate form data

        // save to database

        // show success message

        // userservice 
        // message= "registered successfully";

        // redirect login page
        return "redirect:/register";
    }
}
