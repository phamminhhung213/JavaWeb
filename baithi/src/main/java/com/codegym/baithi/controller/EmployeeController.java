package com.codegym.baithi.controller;

import com.codegym.baithi.model.Employee;
import com.codegym.baithi.model.Part;
import com.codegym.baithi.service.EmployeeService;
import com.codegym.baithi.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PartService partService;

    @ModelAttribute("parts")
    public Page<Part> parts(Pageable pageable){
        return partService.findAll(pageable);
    }

    @GetMapping("/employees")
    public ModelAndView listEmployee(@RequestParam("s") Optional<String> s, @PageableDefault(value = 5) Pageable pageable) {
        Page<Employee> employees;
        if (s.isPresent()) {
//            employees = employeeService.findByFullNameContaining(s.get(),pageable);
            employees = employeeService.findByCodeEmployee(s.get(),pageable);
        } else {
            employees= employeeService.findAll(pageable);
        }
        return new ModelAndView("employee/list", "employees", employees);
    }
    @GetMapping("/employees1")
    public ModelAndView listEmployee1(@RequestParam("s") Optional<String> s, @PageableDefault(value = 5) Pageable pageable) {
        Page<Employee> employees;
        if (s.isPresent()) {
//            employees = employeeService.findByFullNameContaining(s.get(),pageable);
            employees = employeeService.findByIdNumber(s.get(),pageable);
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
    public ModelAndView createEmployee(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("employee/create");
            modelAndView.addObject("message", "New Employee created not successfully");
            return modelAndView;
        }
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("employee/create");
        modelAndView.addObject("message", "New Employee created successfully");
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
    public ModelAndView saveEmployee(@Validated  @ModelAttribute("employees") Employee employee, BindingResult bindingResult) {
//        employeeService.save(employee);
//        ModelAndView modelAndView = new ModelAndView("employee/list");
//        modelAndView.addObject("employee", employee);
//        modelAndView.addObject("message", "Employee updated successfully");
//        return modelAndView;
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("employee/edit");
            modelAndView.addObject("message", "Employee edit not successfully");
            return modelAndView;
        }
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("employee/edit");
        modelAndView.addObject("message", "Employee dit successfully");
        return modelAndView;
    }

//    @GetMapping("/delete-employee/{id}")
//    public String deleteEmployee(@ModelAttribute("employee") Employee employee , @PathVariable("id")Long id){
//        employeeService.remove(id);
//        return "redirect:/employees";
//    }
    @GetMapping("/delete-employee/{id}")
    public ModelAndView showFormDelete(@PathVariable("id") Long id) {
        Employee employee = employeeService.findById(id);
        if (employee != null) {
            return new ModelAndView("employee/delete", "employee", employee);
        }
        return new ModelAndView("error.404");
    }

    @PostMapping("/delete-employee")
    public String deleteEmployee(@ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.remove(employee.getId());
        redirectAttributes.addFlashAttribute("message"," Employee deleted successfully");
        return "redirect:employees";
    }
}
