package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.RentType;
import com.codegym.casestudy.model.Services;
import com.codegym.casestudy.service.RentTypeService;
import com.codegym.casestudy.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ServicesController {
    @Autowired
    private ServicesService servicesService;
    @Autowired
    private RentTypeService rentTypeService;

    @ModelAttribute("rentTypes")
    public Page<RentType> rentTypes(Pageable pageable){
        return rentTypeService.findAll(pageable);
    }

    @GetMapping("/services")
    public ModelAndView listServies(@RequestParam("s") Optional<String> s, @PageableDefault(value = 5) Pageable pageable) {
        Page<Services> services;
        if (s.isPresent()) {
            services = servicesService.findByServiceNameContaining(s.get(),pageable);
        } else {
            services= servicesService.findAll(pageable);
        }
        return new ModelAndView("service/list_service", "services", services);
    }
    @GetMapping("create-service")
    public ModelAndView showFormCreate() {
        return new ModelAndView("service/create_service", "service", new Services());
    }
    @PostMapping("create-service")
    public ModelAndView createService(@Validated @ModelAttribute("service") Services service , BindingResult bindingResult) {
//        servicesService.save(service);
//        ModelAndView modelAndView;
//        modelAndView=new ModelAndView("service/create");
//        modelAndView.addObject("service", service);
//        return modelAndView;
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("service/create_service");
            modelAndView.addObject("message", "New Service created not successfully");
            return modelAndView;
        }
        servicesService.save(service);
        ModelAndView modelAndView = new ModelAndView("service/create_service");
        modelAndView.addObject("message", "New Service created successfully");
        return modelAndView;
    }
    @GetMapping("/delete-services/{id}")
    public String deleteService(@ModelAttribute("services") Services services , @PathVariable("id")Long id){
        servicesService.remove(id);
        return "redirect:/services";
    }

    @GetMapping("edit-services/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Services services = servicesService.findById(id);
        if(services != null) {
            ModelAndView modelAndView = new ModelAndView("/service/edit");
            modelAndView.addObject("services", services);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-services")
    public ModelAndView saveService(@Validated @ModelAttribute("services") Services service, BindingResult bindingResult) {
//        servicesService.save(service);
//        Page<Services> services = servicesService.findAll(pageable);
//        ModelAndView modelAndView = new ModelAndView("service/list");
//        modelAndView.addObject("service", service);
//        modelAndView.addObject("message", "Service updated successfully");
//        return modelAndView;
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("service/edit");
            return modelAndView;
        }
        servicesService.save(service);
        ModelAndView modelAndView = new ModelAndView("service/list_service");
        return modelAndView;
    }
}
