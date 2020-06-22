package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.Position;
import com.codegym.casestudy.service.PositionService;
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
public class PositionController {
    @Autowired
    private PositionService positionService;

    @GetMapping("/positions")
    public ModelAndView listPosition(Pageable pageable) {
        Page<Position> positions = positionService.findAll(pageable);
        return new ModelAndView("position/list", "positions", positions);
    }

    @GetMapping("create-position")
    public ModelAndView showFormCreate() {
        return new ModelAndView("position/create", "position", new Position());
    }
    @PostMapping("create-position")
    public ModelAndView createPosition(@ModelAttribute("position") Position position) {
        positionService.save(position);
        ModelAndView modelAndView;
        modelAndView=new ModelAndView("position/create");
        modelAndView.addObject("position", position);
        modelAndView.addObject("message", "New position created successfully");
        return modelAndView;
    }

    @GetMapping("edit-position/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Position position = positionService.findById(id);
        if(position != null) {
            ModelAndView modelAndView = new ModelAndView("/position/edit");
            modelAndView.addObject("position", position);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-position")
    public ModelAndView savePosition(@ModelAttribute("positions") Position position) {
        positionService.save(position);
        ModelAndView modelAndView = new ModelAndView("position/list");
        modelAndView.addObject("position", position);
        modelAndView.addObject("message", "Position updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-position/{id}")
    public String deletePosition(@ModelAttribute("position") Position position , @PathVariable("id")Long id){
        positionService.remove(id);
        return "redirect:/positions";
    }
}
