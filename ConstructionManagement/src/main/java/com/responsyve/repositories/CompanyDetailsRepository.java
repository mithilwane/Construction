package com.responsyve.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.responsyve.domain.CompanyDetails;

public interface CompanyDetailsRepository extends CrudRepository<CompanyDetails, Integer>{
	
	@Query("from CompanyDetails c where c.companyname=:cname")
	public Iterable<CompanyDetails> findByCompanyName(@Param("cname") String cname);
}