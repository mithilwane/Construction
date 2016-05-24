package com.responsyve;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.responsyve.domain.CompanyDetails;
import com.responsyve.repositories.CompanyDetailsRepository;
import com.responsyve.repositories.RepositoryConfiguration;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class CompanyDetailsRepositoryTest {

    private CompanyDetailsRepository companyDetailsRepository;

    @Autowired
    public void setcompanyDetailsRepository(CompanyDetailsRepository companyDetailsRepository) {
        this.companyDetailsRepository = companyDetailsRepository;
    }

    @Test
    public void testSaveProduct(){
        //setup product
        CompanyDetails companyDetails = new CompanyDetails();
        companyDetails.setCompanyname("Aarchi Builders Pvt Ltd");
        companyDetails.setAddress("A-11, Taruvel, Tarun Bharat Road, Andheri East");
        companyDetails.setAddress("Aarchi Mithil Wane");
        companyDetails.setProjects(10);
        
        
        //save product, verify has ID value after save
        assertNull(companyDetails.getId()); //null before save
        companyDetailsRepository.save(companyDetails);
        assertNotNull(companyDetails.getId()); //not null after save

        //fetch from DB
        CompanyDetails fetchedDetails = companyDetailsRepository.findOne(companyDetails.getId());

        //should not be null
        assertNotNull(fetchedDetails);

        //should equal
        assertEquals(companyDetails.getId(), fetchedDetails.getId());
        assertEquals(companyDetails.getCompanyname(), fetchedDetails.getCompanyname());

        //update description and save
        fetchedDetails.setAddress("E-303, Globe Heights, Film City Road, Goregaon East");
        companyDetailsRepository.save(fetchedDetails);

        //get from DB, should be updated
        CompanyDetails fetchedUpdatedDetails = companyDetailsRepository.findOne(fetchedDetails.getId());
        assertEquals(fetchedUpdatedDetails.getAddress(), fetchedUpdatedDetails.getAddress());

        //verify count of products in DB
        long productCount = companyDetailsRepository.count();
        assertEquals(productCount, 1);

        //get all products, list should only have one
        Iterable<CompanyDetails> compdetails = companyDetailsRepository.findAll();

        int count = 0;

        for(CompanyDetails p : compdetails){
            count++;
        }

        assertEquals(count, 1);
    }
}