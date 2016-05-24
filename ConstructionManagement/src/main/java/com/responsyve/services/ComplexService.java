package com.responsyve.services;

import com.responsyve.domain.Complex;

public interface ComplexService {
    Iterable<Complex> listAllComplex();

    Complex getComplexById(Integer id);
    
    Iterable<Complex> getComplexByName(String complexname);

    Complex saveComplex(Complex complex);

    void deleteComplex(Integer id);
}