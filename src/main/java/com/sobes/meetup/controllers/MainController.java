package com.sobes.meetup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
//    public String home(Model model) {
//        model.addAttribute("title", "SberSOBES");
//        return "home";
//    }

    @GetMapping("/homeUser")
    public String homeUser(Model model) {
        model.addAttribute("title", "SberSOBES");
        return "homeUser";
    }
    @GetMapping("/auth")
    public String auth(Model model) {
        model.addAttribute("title", "SberSOBES");
        return "auth";
    }


}