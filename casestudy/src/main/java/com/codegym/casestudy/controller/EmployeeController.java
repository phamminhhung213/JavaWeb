package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.*;
import com.codegym.casestudy.service.DegreeService;
import com.codegym.casestudy.service.EmployeeService;
import com.codegym.casestudy.service.PartService;
import com.codegym.casestudy.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DegreeService degreeService;
    @Autowired
    private PartService partService;
    @Autowired
    private PositionService positionService;

    @ModelAttribute("degrees")
    public Page<Degree> degrees(Pageable pageable){
        return degreeService.findAll(pageable);
    }

    @ModelAttribute("parts")
    public Page<Part> parts(Pageable pageable){
        return partService.findAll(pageable);
    }

    @ModelAttribute("positions")
    public Page<Position> positions(Pageable pageable){
        return positionService.findAll(pageable);
    }

    @GetMapping("/employees")
    public ModelAndView listEmployee(@RequestParam("s") Optional<String> s, @PageableDefault(value = 5) Pageable pageable) {
        Page<Employee> employees;
        if (s.isPresent()) {
            employees = employeeService.findByFullNameContaining(s.get(),pageable);
        } else {
            employees= employeeService.findAll(pageable);
        }
        return new ModelAndView("employee/list", "employees", employees);
    }

    @GetMapping("create-employee")
    public ModelAndView showFormCreate() {
        return new ModelAndView("employee/create", "employee", new Employee());
    }
    @PostMapping("create-employee")
    public ModelAndView createEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        ModelAndView modelAndView;
        modelAndView=new ModelAndView("employee/create");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @GetMapping("edit-employee/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Employee employee = employeeService.findById(id);
        if(employee != null) {
            ModelAndView modelAndView = new ModelAndView("/employee/edit");
            modelAndView.addObject("employee", employee);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-employee")
    public ModelAndView saveEmployee(@ModelAttribute("employees") Employee employee) {
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("employee/list");
        modelAndView.addObject("employee", employee);
        modelAndView.addObject("message", "Employee updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-employee/{id}")
    public String deleteEmployee(@ModelAttribute("employee") Employee employee , @PathVariable("id")Long id){
        employeeService.remove(id);
        return "redirect:/employees";
    }
    
}
