package com.gcu.cst326clc.controller;

import com.gcu.cst326clc.business.UserBusinessService;
import com.gcu.cst326clc.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserBusinessService userBusinessService;

    @GetMapping("/")
    public ModelAndView display() {
        ModelAndView modelAndView = new ModelAndView();
        UserModel userModel = new UserModel();
        modelAndView.addObject("title", "Registration Form");
        modelAndView.addObject("userModel", userModel);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping("/register")
    public String register(@Valid UserModel userModel, BindingResult bindingResult, Model model) {
        // Check validation errors
        ModelAndView modelAndView = new ModelAndView();
        if(bindingResult.hasErrors())
        {
            modelAndView.addObject("title", "Registration Form");
            return "registration";
        }
        if (userBusinessService.createUser(userModel)){
            return "login";
        }else {
            return "registration";
        }

    }
}
