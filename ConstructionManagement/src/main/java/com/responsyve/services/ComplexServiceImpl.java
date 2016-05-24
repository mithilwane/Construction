package com.responsyve.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.responsyve.domain.Complex;
import com.responsyve.repositories.ComplexRepository;
import com.responsyve.repositories.ComplexRepository;

@Service
public class ComplexServiceImpl implements ComplexService {

	private ComplexRepository complexRepository;

	@Autowired
	public void setComplexRepository(ComplexRepository complexRepository) {
		this.complexRepository = complexRepository;
	}

	@Override
	public Iterable<Complex> listAllComplex() {
		return complexRepository.findAll();
	}

	@Override
	public Complex getComplexById(Integer id) {
		return complexRepository.findOne(id);
	}
	
	@Override
	public Iterable<Complex> getComplexByName(String complexname) {
		return complexRepository.findByComplexName(complexname);
	}

	@Override
	public Complex saveComplex(Complex Complex) {
		return complexRepository.save(Complex);
	}

	@Override
	public void deleteComplex(Integer id) {
		complexRepository.delete(id);
	}

}
