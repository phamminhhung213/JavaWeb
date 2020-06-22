package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.Accompany;
import com.codegym.casestudy.service.AccompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AccompanyController {
    @Autowired
    private AccompanyService accompanyService;

    @GetMapping("/accompanys")
    public ModelAndView listAccompany(Pageable pageable) {
        Page<Accompany> accompanys = accompanyService.findAll(pageable);
        return new ModelAndView("accompany/list", "accompanys", accompanys);
    }

    @GetMapping("create-accompany")
    public ModelAndView showFormCreate() {
        return new ModelAndView("accompany/create", "accompany", new Accompany());
    }
    @PostMapping("create-accompany")
    public ModelAndView createAccompany(@ModelAttribute("accompany") Accompany accompany) {
        accompanyService.save(accompany);
        ModelAndView modelAndView;
        modelAndView=new ModelAndView("accompany/create");
        modelAndView.addObject("accompany", accompany);
        modelAndView.addObject("message", "Create Accompany successfully");
        return modelAndView;
    }

    @GetMapping("edit-accompany/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Accompany accompany = accompanyService.findById(id);
        if(accompany != null) {
            ModelAndView modelAndView = new ModelAndView("/accompany/edit");
            modelAndView.addObject("accompany", accompany);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-accompany")
    public ModelAndView saveAccompany(@ModelAttribute("accompanys") Accompany accompany) {
        accompanyService.save(accompany);
        ModelAndView modelAndView = new ModelAndView("service/list");
        modelAndView.addObject("accompany", accompany);
        modelAndView.addObject("message", "Accompany updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-accompany/{id}")
    public String deleteAccompany(@ModelAttribute("accompany") Accompany accompany , @PathVariable("id")Long id){
        accompanyService.remove(id);
        return "redirect:/accompanys";
    }
}
