package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

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
        UserForm userForm = new UserForm();
        // userForm.setName("toufiqul islam");
        model.addAttribute("userForm", userForm);
        return "register";
    }

    // processing register page
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult,
            HttpSession session) {
        System.out.println("Processing Register Form");
        // fetch form data
        // UserForm
        System.out.println(userForm);
        // validate form data
        if (rBindingResult.hasErrors()) {
            return "register";
        }

        // save to database

        // show success message

        // userservice
        /*
         * // UserForm --> User
         * User user = User.builder()
         * .name(userForm.getName())
         * .email(userForm.getEmail())
         * .password(userForm.getPassword())
         * .about(userForm.getAbout())
         * .phoneNumber(userForm.getPhoneNumber())
         * .profilePic(
         * "https://images.ctfassets.net/h6goo9gw1hh6/2sNZtFAWOdP1lmQ33VwRN3/24e953b920a9cd0ff2e1d587742a2472/1-intro-photo-final.jpg?w=1200&h=992&fl=progressive&q=70&fm=jpg")
         * .build();
         */
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic(
                "https://images.ctfassets.net/h6goo9gw1hh6/2sNZtFAWOdP1lmQ33VwRN3/24e953b920a9cd0ff2e1d587742a2472/1-intro-photo-final.jpg?w=1200&h=992&fl=progressive&q=70&fm=jpg");
        User saveUser = userService.saveUser(user);

        System.out.println("user saved.");
        // message= "registered successfully";

        // add the message
        Message message = Message.builder().content("Registered Successfully !!").type(MessageType.green).build();
        session.setAttribute("message", message);

        // redirect login page
        return "redirect:/register";
    }
}
