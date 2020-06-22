package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.Accompany;
import com.codegym.casestudy.model.Contract;
import com.codegym.casestudy.model.ContractDetail;
import com.codegym.casestudy.service.AccompanyService;
import com.codegym.casestudy.service.ContractDetailService;
import com.codegym.casestudy.service.ContractService;
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
public class ContractDetailController {
    @Autowired
    private ContractDetailService contractDetailService;

    @Autowired
    private ContractService contractService;
    @Autowired
    private AccompanyService accompanyService;

    @ModelAttribute("contracts")
    public Page<Contract> contracts(Pageable pageable){
        return contractService.findAll(pageable);
    }
    @ModelAttribute("accompanys")
    public Page<Accompany> accompanys(Pageable pageable){
        return accompanyService.findAll(pageable);
    }

    @GetMapping("/contractDetails")
    public ModelAndView listContractDetail(Pageable pageable) {
        Page<ContractDetail> contractDetails = contractDetailService.findAll(pageable);
        return new ModelAndView("contractDetail/list", "contractDetails", contractDetails);
    }

    @GetMapping("create-contractDetail")
    public ModelAndView showFormCreate() {
        return new ModelAndView("contractDetail/create", "contractDetail", new ContractDetail());
    }
    @PostMapping("create-contractDetail")
    public ModelAndView createContractDetail(@ModelAttribute("contractDetail") ContractDetail contractDetail) {
        contractDetailService.save(contractDetail);
        ModelAndView modelAndView;
        modelAndView=new ModelAndView("contractDetail/create");
        modelAndView.addObject("contractDetail", contractDetail);
        return modelAndView;
    }

    @GetMapping("edit-contractDetail/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        ContractDetail contractDetail = contractDetailService.findById(id);
        if(contractDetail != null) {
            ModelAndView modelAndView = new ModelAndView("/contractDetail/edit");
            modelAndView.addObject("contractDetail", contractDetail);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-contractDetail")
    public ModelAndView saveContractDetail(@ModelAttribute("contractDetails") ContractDetail contractDetail) {
        contractDetailService.save(contractDetail);
        ModelAndView modelAndView = new ModelAndView("contractDetail/list");
        modelAndView.addObject("contractDetail", contractDetail);
        modelAndView.addObject("message", "ContractDetail updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-contractDetail/{id}")
    public String deleteContractDetail(@ModelAttribute("contractDetail") ContractDetail contractDetail , @PathVariable("id")Long id){
        contractDetailService.remove(id);
        return "redirect:/contractDetails";
    }
}
