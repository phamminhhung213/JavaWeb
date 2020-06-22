package com.codegym.casestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @GetMapping("/")
    public String index()   {
        return "layout_new";
    }

    @GetMapping("search")
    public ModelAndView search() {
        return new ModelAndView("show/search");
    }

    @GetMapping("register")
    public ModelAndView register() {
        return new ModelAndView("index");
    }

    @GetMapping("login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

}
