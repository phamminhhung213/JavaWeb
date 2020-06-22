package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.RentType;
import com.codegym.casestudy.service.RentTypeService;
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
public class RentTypeController {
    @Autowired
    private RentTypeService rentTypeService;

    @GetMapping("/rentTypes")
    public ModelAndView listRentType(Pageable pageable) {
        Page<RentType> rentTypes = rentTypeService.findAll(pageable);
        return new ModelAndView("rentType/list", "rentTypes", rentTypes);
    }

    @GetMapping("create-rentType")
    public ModelAndView showFormCreate() {
        return new ModelAndView("rentType/create", "rentType", new RentType());
    }
    @PostMapping("create-rentType")
    public ModelAndView createRentType(@ModelAttribute("rentType") RentType rentType) {
        rentTypeService.save(rentType);
        ModelAndView modelAndView;
        modelAndView=new ModelAndView("rentType/create");
        modelAndView.addObject("rentType", rentType);
        modelAndView.addObject("message", "New rentType created successfully");
        return modelAndView;
    }

    @GetMapping("edit-rentType/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        RentType rentType = rentTypeService.findById(id);
        if(rentType != null) {
            ModelAndView modelAndView = new ModelAndView("/rentType/edit");
            modelAndView.addObject("rentType", rentType);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-rentType")
    public ModelAndView saveRentType(@ModelAttribute("rentTypes") RentType rentType) {
        rentTypeService.save(rentType);
        ModelAndView modelAndView = new ModelAndView("rentType/list");
        modelAndView.addObject("rentType", rentType);
        modelAndView.addObject("message", "RentType updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-rentType/{id}")
    public String deleteRentType(@ModelAttribute("rentType") RentType rentType , @PathVariable("id")Long id){
        rentTypeService.remove(id);
        return "redirect:/rentTypes";
    }
}
