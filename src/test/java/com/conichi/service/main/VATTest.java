package com.conichi.service.main;


import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;

import com.conichi.service.controllers.CurrencyConverter;
import com.conichi.service.controllers.VATValidation;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

/**
 * 
 * @author Sherine.Emad
 * Test VAT conversion results
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = VATValidation.class)
public class VATTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	    
    @Test
    public void vatSuccessValidationTest(){

        System.out.println("Testing VAT conversion API-----------");
          
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
    			"/VAT/AU4406704").accept(
    			MediaType.APPLICATION_JSON);
        
        MvcResult result;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
			System.out.println("Content back "+result.getResponse().getContentAsString());
			String expected = "{\"countryCode\":\"AU\",\"vatNumber\":\"4406704\",\"valid\":true}";
			JSONAssert.assertEquals(expected, result.getResponse()
					.getContentAsString(), false);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
		@Test
	    public void vatValidationErrorTest(){

	        System.out.println("Testing VAT conversion in-correct API-----------");
	          
	        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
	    			"/VAT/AU4406704").accept(
	    			MediaType.APPLICATION_JSON);
	        
	        MvcResult result;
			try {
				result = mockMvc.perform(requestBuilder).andReturn();
				System.out.println("Content back "+result.getResponse().getContentAsString());
				String expected = "{\"countryCode\":\"AU\",\"vatNumber\":\"440645454\",\"valid\":true}";
				JSONAssert.assertNotEquals(expected, result.getResponse()
						.getContentAsString(), false);
			} catch (Exception e) {
				e.printStackTrace();
			}
    }
		
		@Test
	    public void vatDifferentValueTest(){

	        System.out.println("Testing VAT conversion in-correct API-----------");
	          
	        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
	    			"/VAT/NL80.49.73.787.B01").accept(
	    			MediaType.APPLICATION_JSON);
	        
	        MvcResult result;
			try {
				result = mockMvc.perform(requestBuilder).andReturn();
				System.out.println("Content back "+result.getResponse().getContentAsString());
				String expected = "{\"countryCode\":\"NL\",\"vatNumber\":\"80.49.73.787.B01\",\"valid\":true}";
				JSONAssert.assertEquals(expected, result.getResponse()
						.getContentAsString(), false);
			} catch (Exception e) {
				e.printStackTrace();
			}


    }
}
