package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.Contract;
import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.model.Employee;
import com.codegym.casestudy.model.Services;
import com.codegym.casestudy.service.ContractService;
import com.codegym.casestudy.service.CustomerService;
import com.codegym.casestudy.service.EmployeeService;
import com.codegym.casestudy.service.ServicesService;
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
public class ContractController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ServicesService servicesService;

    @ModelAttribute("customers")
    public Page<Customer> customers(Pageable pageable){
        return customerService.findAll(pageable);
    }

    @ModelAttribute("employees")
    public Page<Employee> employees(Pageable pageable){
        return employeeService.findAll(pageable);
    }

    @ModelAttribute("services")
    public Page<Services> services(Pageable pageable){
        return servicesService.findAll(pageable);
    }

    @GetMapping("/contracts")
    public ModelAndView listContract(Pageable pageable) {
        Page<Contract> contracts = contractService.findAll(pageable);
        return new ModelAndView("contract/list", "contracts", contracts);
    }

    @GetMapping("create-contract")
    public ModelAndView showFormCreate() {
        return new ModelAndView("contract/create", "contract", new Contract());
    }
    @PostMapping("create-contract")
    public ModelAndView createContract(@ModelAttribute("contract") Contract contract) {
        contractService.save(contract);
        ModelAndView modelAndView;
        modelAndView=new ModelAndView("contract/create");
        modelAndView.addObject("contract", contract);
        return modelAndView;
    }

    @GetMapping("edit-contract/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Contract contract = contractService.findById(id);
        if(contract != null) {
            ModelAndView modelAndView = new ModelAndView("/contract/edit");
            modelAndView.addObject("contract", contract);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-contract")
    public ModelAndView saveContract(@ModelAttribute("contracts") Contract contract) {
        contractService.save(contract);
        ModelAndView modelAndView = new ModelAndView("contract/list");
        modelAndView.addObject("contract", contract);
        modelAndView.addObject("message", "Contract updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-contract/{id}")
    public String deleteContract(@ModelAttribute("contract") Contract contract , @PathVariable("id")Long id){
        contractService.remove(id);
        return "redirect:/contracts";
    }
}
