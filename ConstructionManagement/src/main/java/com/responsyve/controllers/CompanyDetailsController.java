package com.responsyve.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.responsyve.domain.CompanyDetails;
import com.responsyve.services.CompanyDetailsService;

@Controller
public class CompanyDetailsController {
	
	private CompanyDetailsService companyDtlsSrvc;
	
	@Autowired
    public void setCompanyDetailsService(CompanyDetailsService companyDtlsSrvc) {
        this.companyDtlsSrvc = companyDtlsSrvc;
    }
	
	@RequestMapping(value = "/companys", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("companys", companyDtlsSrvc.listAllCompanyDetails());
        return "companys";
    }

    @RequestMapping("company/{id}")
    public String showCompany(@PathVariable Integer id, Model model){
        model.addAttribute("company", companyDtlsSrvc.getCompanyDetailsById(id));
        return "companyshow";
    }
    
    @RequestMapping("companybyname/{name}")
    public String showCompanyByName(@PathVariable String name, Model model){
    	
    	Iterable<CompanyDetails> compDtls = companyDtlsSrvc.getCompanyDetailsByName(name);
    	for (CompanyDetails company : compDtls) {
    		model.addAttribute("company", company);
    		break;
		}
    	
        return "companyshow";
    }

    @RequestMapping("company/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("company", companyDtlsSrvc.getCompanyDetailsById(id));
        return "companyform";
    }

    @RequestMapping("company/new")
    public String newCompany(Model model){
        model.addAttribute("company", new CompanyDetails());
        return "companyform";
    }

    @RequestMapping(value = "company", method = RequestMethod.POST)
    public String saveCompany(CompanyDetails company){
        companyDtlsSrvc.saveCompanyDetails(company);
        return "redirect:/company/" + company.getId();
    }

    @RequestMapping("company/delete/{id}")
    public String delete(@PathVariable Integer id){
        companyDtlsSrvc.deleteCompanyDetails(id);
        return "redirect:/companys";
    }
    
    

}
