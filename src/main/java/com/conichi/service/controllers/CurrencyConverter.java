package com.conichi.service.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.conichi.service.beans.CurrencyConversionBean;
import com.conichi.service.utilities.Utility;

/**
 * 
 * @author Sherine.Emad
 * Currency converter controller to manage URL get request and response back
 */
@Controller
public class CurrencyConverter {

	/**
	 * Default constructor
	 */
	public CurrencyConverter() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param from : Currency type as provided by user
	 * @param to  : type of currency want to transfer to 
	 * @param quantity :quantity want to be transferred
	 */
	@RequestMapping(method = RequestMethod.GET, value="/currency/convert/{from}/{to}/{quantity}")
	/**
	 * 
	 * @param from : Currency type as provided by user
	 * @param to  : type of currency want to transfer to 
	 * @param quantity :quantity want to be transferred
	 * @return response : in JSON format of currency bean type
	 */
	@ResponseBody
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable double quantity) {
		//Utility object to handle JSON data processing
		Utility currencyUtility=new Utility();
		
		return new CurrencyConversionBean(from, to, quantity,
				   currencyUtility.CurrencyParsingStringUtility(from.toString(), to.toString(), quantity));
			
	}

}
