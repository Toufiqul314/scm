package com.scm.controllers;

import java.lang.module.ModuleDescriptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.services.UserService;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

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
    public String registerPage(Model model){

        UserForm userForm = new UserForm();
        //default data set for register page
        //userForm.setName("Toufiqul Islam");
        model.addAttribute("userForm",userForm);

        return "register";
    }

    //processing register 
    @RequestMapping(value="/do-register",method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm){
        System.out.println("processing register");
        // fetch form data
        // UserForm class 
        System.out.println(userForm);
        // validate form data
        //save to database

        // userservice
        // UserForm converter ---> User data
        User user=User.builder()
        .name(userForm.getName())
        .email(userForm.getEmail())
        .password(userForm.getPassword())
        .about(userForm.getAbout())
        .phoneNumber(userForm.getPhoneNumber())
        .profilePic("https://i.sstatic.net/l60Hf.png")
        .build();
        
        User saveUser=userService.saveUser(user);
        System.out.println("save user: "+saveUser);

        // message ="Registration successful";

        //redirectto register page
        return "redirect:/register";
    }
}
