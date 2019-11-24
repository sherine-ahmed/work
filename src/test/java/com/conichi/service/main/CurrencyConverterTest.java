package com.conichi.service.main;


import org.junit.runner.RunWith;

import org.junit.jupiter.api.Test;

import com.conichi.service.controllers.CurrencyConverter;


import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;

import org.skyscreamer.jsonassert.JSONAssert;
/**
 * 
 * @author Sherine.Emad
 * Test currency conversion and result
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value = CurrencyConverter.class)
class CurrencyConverterTest {
	@Autowired
	private MockMvc mockMvc;
	
	    
    @Test
    public void convertCurrencyTest(){

        System.out.println("Testing Currency conversion API-----------");
          
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
    			"/currency/convert/USDBYN/USDBYR/8").accept(
    			MediaType.APPLICATION_JSON);
        
        MvcResult result;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
			System.out.println("Content back "+result.getResponse().getContentAsString());
			String expected = "{\"from\":\"USDBYN\",\"to\":USDBYR,\"quantity\":8.0,\"totalCalculatedAmount\":76592.9052890625}";
			JSONAssert.assertEquals(expected, result.getResponse()
					.getContentAsString(), false);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @Test
    public void inCorrectCurrencyConversionTest(){

        System.out.println("Testing Currency conversion API in correct values-----------");
          
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
    			"/currency/convert/USDBYN/USDBYR/8").accept(
    			MediaType.APPLICATION_JSON);
        
        MvcResult result;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
			System.out.println("Content back "+result.getResponse().getContentAsString());
			String expected = "{\"from\":\"USDBYN\",\"to\":USDBYR,\"quantity\":7,\"totalCalculatedAmount\":76592.9052890625}";
			JSONAssert.assertNotEquals(expected, result.getResponse()
					.getContentAsString(), false);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
   
    @Test
    public void convertCurrencyDifferentValueTest(){

        System.out.println("Testing Currency conversion API different value-----------");
          
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
    			"/currency/convert/USDAWG/USDBGN/5").accept(
    			MediaType.APPLICATION_JSON);

        MvcResult result;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
			System.out.println("Content back "+result.getResponse().getContentAsString());
			String expected = "{\"from\":\"USDAWG\",\"to\":\"USDBGN\",\"quantity\":5.0,\"totalCalculatedAmount\":4.901}";
			JSONAssert.assertEquals(expected, result.getResponse()
					.getContentAsString(), false);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
