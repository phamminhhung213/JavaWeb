package com.codegym.baithi.controller;

import com.codegym.baithi.model.Part;
import com.codegym.baithi.service.PartService;
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
public class PartController {
    @Autowired
    private PartService partService;

    @GetMapping("/parts")
    public ModelAndView listPart(Pageable pageable) {
        Page<Part> parts = partService.findAll(pageable);
        return new ModelAndView("part/list", "parts", parts);
    }

    @GetMapping("create-part")
    public ModelAndView showFormCreate() {
        return new ModelAndView("part/create", "part", new Part());
    }
    @PostMapping("create-part")
    public ModelAndView createPart(@ModelAttribute("part") Part part) {
        partService.save(part);
        ModelAndView modelAndView;
        modelAndView=new ModelAndView("part/create");
        modelAndView.addObject("part", part);
        modelAndView.addObject("message", "New part created successfully");
        return modelAndView;
    }

    @GetMapping("edit-part/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Part part = partService.findById(id);
        if(part != null) {
            ModelAndView modelAndView = new ModelAndView("/part/edit");
            modelAndView.addObject("part", part);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-part")
    public ModelAndView savePart(@ModelAttribute("parts") Part part) {
        partService.save(part);
        ModelAndView modelAndView = new ModelAndView("part/list");
        modelAndView.addObject("part", part);
        modelAndView.addObject("message", "Part updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-part/{id}")
    public String deletePart(@ModelAttribute("part") Part part , @PathVariable("id")Long id){
        partService.remove(id);
        return "redirect:/parts";
    }
}
