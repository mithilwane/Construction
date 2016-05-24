package com.responsyve.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.responsyve.domain.Complex;

public interface ComplexRepository extends CrudRepository<Complex, Integer>{	
	
	@Query("from Complex c where c.complexname=:cname")
	public Iterable<Complex> findByComplexName(@Param("cname") String cname);
}