package com.conichi.service.main;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.conichi.service.controllers.CurrencyConverter;

/**
 * 
 * @author Sherine.Emad
 * Test application up and running with different code values
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = CurrencyConverter.class)
class ConichiApplicationTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	    
    @Test
    public void applicationRunSuccessfullyTest(){

        System.out.println("Testing Application successfully up and running-----------");
          
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
    			"/currency/convert/USDBYN/USDBYR/8").accept(
    			MediaType.APPLICATION_JSON);
        
        MvcResult result;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
			Assert.assertEquals(200, result.getResponse().getStatus());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }	

}
