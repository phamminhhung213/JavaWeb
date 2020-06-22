package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.Degree;
import com.codegym.casestudy.service.DegreeService;
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
public class DegreeController {
    @Autowired
    private DegreeService degreeService;

    @GetMapping("/degrees")
    public ModelAndView listDegree(Pageable pageable) {
        Page<Degree> degrees = degreeService.findAll(pageable);
        return new ModelAndView("degree/list", "degrees", degrees);
    }

    @GetMapping("create-degree")
    public ModelAndView showFormCreate() {
        return new ModelAndView("degree/create", "degree", new Degree());
    }
    @PostMapping("create-degree")
    public ModelAndView createDegree(@ModelAttribute("degree") Degree degree) {
        degreeService.save(degree);
        ModelAndView modelAndView;
        modelAndView=new ModelAndView("degree/create");
        modelAndView.addObject("degree", degree);
        modelAndView.addObject("message", "Create Degree successfully");
        return modelAndView;
    }

    @GetMapping("edit-degree/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Degree degree = degreeService.findById(id);
        if(degree != null) {
            ModelAndView modelAndView = new ModelAndView("/degree/edit");
            modelAndView.addObject("degree", degree);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-degree")
    public ModelAndView saveDegree(@ModelAttribute("degrees") Degree degree) {
        degreeService.save(degree);
        ModelAndView modelAndView = new ModelAndView("degree/list");
        modelAndView.addObject("degree", degree);
        modelAndView.addObject("message", "Degree updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-degree/{id}")
    public String deleteDegree(@ModelAttribute("degree") Degree degree , @PathVariable("id")Long id){
        degreeService.remove(id);
        return "redirect:/degrees";
    }
}
