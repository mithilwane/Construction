package com.responsyve.services;

import com.responsyve.domain.CompanyDetails;

public interface CompanyDetailsService {
    Iterable<CompanyDetails> listAllCompanyDetails();

    CompanyDetails getCompanyDetailsById(Integer id);
    
    Iterable<CompanyDetails> getCompanyDetailsByName(String companyname);

    CompanyDetails saveCompanyDetails(CompanyDetails companyDetails);

    void deleteCompanyDetails(Integer id);
}