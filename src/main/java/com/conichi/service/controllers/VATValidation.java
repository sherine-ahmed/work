package com.conichi.service.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.conichi.service.beans.VATValidationBean;
import com.conichi.service.utilities.VATUtility;

/**
 * 
 * @author Sherine.Emad
 * VAT controller to manage URL get request and response back
 */
@Controller
public class VATValidation {

	/**
	 * Default Constructor
	 */
	public VATValidation() {
		
	}
	/**
	 * 
	 * @param vatID : provided VAT ID from user
	 */
	@RequestMapping(method = RequestMethod.GET, value="/VAT/{vatID}")
	/**
	 * 
	 * @param vatID
	 * @return response : JSON format of VAT bean type
	 */
	@ResponseBody
	public  VATValidationBean validateVAT(@PathVariable String vatID) {
		// utility object to handle the ID processing
		VATUtility utility=new VATUtility();
		if (utility.processProvidedVATID(vatID)) {//JSON has valid IDs other than this isn't valid
		 return new VATValidationBean(utility.getCountryCode(), utility.getVatNumber(),true);
		}else
			return new VATValidationBean("","",false);
	}

}
