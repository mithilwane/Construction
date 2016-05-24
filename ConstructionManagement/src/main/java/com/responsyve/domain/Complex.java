package com.responsyve.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Complex {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Version
	private Integer version;
	
	private String complexname;
	
	private Integer numberofbuildings;
	
	private String complexaddress;
	
	private Integer areaofcomplex;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name="company_id",referencedColumnName="id")
	private CompanyDetails companydetails;
}
