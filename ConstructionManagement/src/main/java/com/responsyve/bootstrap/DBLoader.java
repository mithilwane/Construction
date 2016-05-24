package com.responsyve.bootstrap;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.responsyve.domain.CompanyDetails;
import com.responsyve.domain.Complex;
import com.responsyve.repositories.CompanyDetailsRepository;
import com.responsyve.repositories.ComplexRepository;

@Component
public class DBLoader implements ApplicationListener<ContextRefreshedEvent> {

    private CompanyDetailsRepository companyDetailsRepository;
    private ComplexRepository complexRepository;

    private Logger log = Logger.getLogger(DBLoader.class);

    @Autowired
    public void setCompanyDetailsRepository(CompanyDetailsRepository companyDetailsRepository) {
        this.companyDetailsRepository = companyDetailsRepository;
    }
    
    @Autowired
    public void setComplexRepository(ComplexRepository complexRepository){
    	this.complexRepository = complexRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

    	Complex complexAur = new Complex();
        complexAur.setAreaofcomplex(36000);
        complexAur.setComplexaddress("Film City Road");
        complexAur.setComplexname("Aurora");
        complexAur.setNumberofbuildings(10);
        
        CompanyDetails companyAarchi = new CompanyDetails();
        companyAarchi.setCompanyname("Aarchi Builders Pvt Ltd");
        companyAarchi.setOwner("Aarchi Mithil Wane");
        companyAarchi.setAddress("A-11, Taruvel, Tarun Bharat Road, Andheri East");
        companyAarchi.setProjects(10);
        
        ArrayList<Complex> compx = new ArrayList<>();
        compx.add(complexAur);
        companyAarchi.setComplex(compx);
        
        companyDetailsRepository.save(companyAarchi);
        
        log.info("Saved Company - id: " + companyAarchi.getId());
                
        complexAur.setCompanydetails(companyAarchi);
        
        complexRepository.save(complexAur);
        
        log.info("Saved Complex - id: " + complexAur.getId());
        
        Complex complexCind = new Complex();
        complexCind.setAreaofcomplex(40000);
        complexCind.setComplexaddress("Film City Road");
        complexCind.setComplexname("Cinderalla");
        complexCind.setNumberofbuildings(10);

        CompanyDetails companyAarohi = new CompanyDetails();
        companyAarohi.setCompanyname("Aarohi Builders Pvt Ltd");
        companyAarohi.setOwner("Aarohi Mithil Wane");
        companyAarohi.setAddress("E-303, Globe Heights, Film City Road, Goregaon East");
        companyAarohi.setProjects(10);
        
        ArrayList<Complex> compc = new ArrayList<>();
        compc.add(complexCind);
        companyAarohi.setComplex(compc);
        
        companyDetailsRepository.save(companyAarohi);
        
        log.info("Saved Company - id: " + companyAarohi.getId());
        
        complexCind.setCompanydetails(companyAarohi);
        complexRepository.save(complexCind);
        
        log.info("Saved Complex - id: " + complexCind.getId());
        
        Complex complexSW = new Complex();
        complexSW.setAreaofcomplex(40000);
        complexSW.setComplexaddress("Film City Road");
        complexSW.setComplexname("SnowWhite");
        complexSW.setNumberofbuildings(10);
        
        CompanyDetails companyNutan = new CompanyDetails();
        companyNutan.setCompanyname("Nutan Builders Pvt Ltd");
        companyNutan.setOwner("Nutan Mithil Wane");
        companyNutan.setAddress("E-303, Globe Heights, Film City Road, Goregaon East");
        companyNutan.setProjects(10);
        companyDetailsRepository.save(companyNutan);
        
        ArrayList<Complex> compsw = new ArrayList<>();
        compsw.add(complexSW);
        companyNutan.setComplex(compsw);
        
        log.info("Saved Company - id: " + companyNutan.getId());
        
        complexSW.setCompanydetails(companyNutan);
        complexRepository.save(complexSW);
        
        log.info("Saved Complex - id: " + complexSW.getId());

    }
}