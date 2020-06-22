package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ModelAndView listCustomer(@RequestParam("s") Optional<String> s, @PageableDefault(value = 5) Pageable pageable) {
        Page<Customer> customers;
        if (s.isPresent()) {
            customers = customerService.findByFullNameContaining(s.get(),pageable);
        } else {
            customers= customerService.findAll(pageable);
        }
        return new ModelAndView("customer/list", "customers", customers);
    }

    @GetMapping("create-customer")
    public ModelAndView showFormCreate() {
        return new ModelAndView("customer/create", "customer", new Customer());
    }
    @PostMapping("create-customer")
    public ModelAndView createCustomer(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Pageable pageable) {
//        customer.setDateTime(new Date());
//        customerService.save(customer);
//        ModelAndView modelAndView;
//        modelAndView=new ModelAndView("customer/create");
//        modelAndView.addObject("customer", customer);
//        return modelAndView;
        ModelAndView modelAndView;
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("/customer/create");
            modelAndView.addObject("message", "New Customer created not successfully");
        } else {
            customerService.save(customer);
            Page<Customer> customers = customerService.findAll(pageable);
            modelAndView = new ModelAndView("customer/list");
            modelAndView.addObject("message", "New Customer created successfully");
            modelAndView.addObject("customers", customers);
        }
        return modelAndView;
    }

    @GetMapping("edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Customer customer = customerService.findById(id);
        if(customer != null) {
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-customer")
    public ModelAndView saveCustomer(@Validated @ModelAttribute("customers") Customer customer, BindingResult bindingResult, Pageable pageable) {
        ModelAndView modelAndView;
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("message", "New Customer created not successfully");
        } else {
            customerService.save(customer);
            Page<Customer> customers = customerService.findAll(pageable);
            modelAndView = new ModelAndView("customer/list");
            modelAndView.addObject("message", "New Customer created successfully");
            modelAndView.addObject("customers", customers);
        }
        return modelAndView;
    }

    @GetMapping("/delete-customer/{id}")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer , @PathVariable("id")Long id){
        customerService.remove(id);
        return "redirect:/customers";
    }
}
