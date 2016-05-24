package com.responsyve.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CompanyDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Version
	private Integer version;

	private String owner;
	
	private String companyname;
	
	private String address;
	
	private Integer projects;
	
	 @OneToMany(mappedBy="companydetails")
	 private List<Complex> complex;	

}
