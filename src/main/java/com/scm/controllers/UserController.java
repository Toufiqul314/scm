package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    // user dashboard

    @RequestMapping(value="/dashboard")
    public String userDashString(){

        return "user/dashboard";
    }
    // user profile page
    @RequestMapping(value="/profile")
    public String userProfile(){

        return "user/profile";
    }

    // user add contacts page

    //user view accounts

    // user edit contacts

    // user delete contacts

    // user search contacts
}
