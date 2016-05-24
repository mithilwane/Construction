package com.responsyve.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.responsyve.domain.CompanyDetails;
import com.responsyve.repositories.CompanyDetailsRepository;

@Service
public class CompanyDetailsServiceImpl implements CompanyDetailsService {

	private CompanyDetailsRepository companyDetailsRepository;

	@Autowired
	public void setCompanyDetailsRepository(CompanyDetailsRepository companyDetailsRepository) {
		this.companyDetailsRepository = companyDetailsRepository;
	}

	@Override
	public Iterable<CompanyDetails> listAllCompanyDetails() {
		return companyDetailsRepository.findAll();
	}

	@Override
	public CompanyDetails getCompanyDetailsById(Integer id) {
		return companyDetailsRepository.findOne(id);
	}
	
	@Override
	public Iterable<CompanyDetails> getCompanyDetailsByName(String companyname) {
		return companyDetailsRepository.findByCompanyName(companyname);
	}

	@Override
	public CompanyDetails saveCompanyDetails(CompanyDetails companyDetails) {
		return companyDetailsRepository.save(companyDetails);
	}

	@Override
	public void deleteCompanyDetails(Integer id) {
		companyDetailsRepository.delete(id);
	}

}
