package com.kh.app07.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {

    @GetMapping
    public String home(Model model) throws Exception {
        model.addAttribute("msg" , "모델객체에담은메세지");
        return "home";
    }

}
