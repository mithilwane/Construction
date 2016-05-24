package com.responsyve.controllers;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.responsyve.domain.Complex;
import com.responsyve.services.CompanyDetailsService;
import com.responsyve.services.ComplexService;

@Controller
public class ComplexController {
	
	private ComplexService complexSrvc;
	private CompanyDetailsService compDtlsSrvc;
	
	@Autowired
    public void setComplexService(ComplexService complexSrvc) {
        this.complexSrvc = complexSrvc;
    }
	
	@Autowired
    public void setCompanyDetailsService(CompanyDetailsService compDtlsSrvc) {
        this.compDtlsSrvc = compDtlsSrvc;
    }
	
	@RequestMapping(value = "/complexs", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("complexs", complexSrvc.listAllComplex());
        return "complexs";
    }

    @RequestMapping("complex/{id}")
    public String showComplex(@PathVariable Integer id, Model model){
        model.addAttribute("complex", complexSrvc.getComplexById(id));
        return "complexshow";
    }
    
    @RequestMapping("complexbyname/{name}")
    public String showComplexByName(@PathVariable String name, Model model){
    	
    	Iterable<Complex> compDtls = complexSrvc.getComplexByName(name);
    	for (Complex complex : compDtls) {
    		model.addAttribute("complex", complex);
    		break;
		}
    	
        return "complexshow";
    }

    @RequestMapping("complex/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("complex", complexSrvc.getComplexById(id));
        return "complexform";
    }

    @RequestMapping("complex/new")
    public String newComplex(Model model){
        model.addAttribute("complex", new Complex());
        model.addAttribute("companylist", compDtlsSrvc.listAllCompanyDetails());
        return "complexform";
    }

    @RequestMapping(value = "complex", method = RequestMethod.POST)
    public String saveComplex(Complex complex){
        complexSrvc.saveComplex(complex);
        return "redirect:/complex/" + complex.getId();
    }

    @RequestMapping("complex/delete/{id}")
    public String delete(@PathVariable Integer id){
        complexSrvc.deleteComplex(id);
        return "redirect:/complexs";
    }
    
    

}
