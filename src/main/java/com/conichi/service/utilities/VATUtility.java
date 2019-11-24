package com.conichi.service.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.fasterxml.jackson.databind.ObjectMapper; 

/**
 * 
 * @author Sherine.Emad
 * VAT utility process VAT ID provided 
 */

public class VATUtility {

	String countryCode;
	String vatNumber;
	/**
	 * Default constructor
	 */
	public VATUtility() {
		
	}
	/**
	 * 
	 * @param VATID : VAT ID provided by user 
	 * @return {@link Boolean} : Status of the ID valid or not
	 */
	public boolean processProvidedVATID(String VATID) {
		String entryKey="";
		String vatDetailedValues;
		//create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();
		boolean result=false;
		//convert json file to map
		HashMap<String, String> map=new HashMap<String, String>();
		try {
			map = objectMapper.readValue(new FileInputStream("src/main/resources/vatResponse.json"), HashMap.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Handle Key/pair value  from JSON
		for (Map.Entry<?, ?> entry : map.entrySet()) {
		    entryKey=entry.getKey().toString().toLowerCase();
		    if (entryKey.equalsIgnoreCase(VATID.toLowerCase())) {
		    	vatDetailedValues=entry.getValue().toString();
		    	parsingVATDetails(vatDetailedValues);
		    	result=true;
		    	break;//Once found target value no need to scan others		    	
		    }		 
		}
       return result;
	}
	/**
	 * 
	 * @param values :Process VAT output required values
	 */
	public void parsingVATDetails(String values){
		
		String [] vatDetails;
		StringTokenizer st = new StringTokenizer(values, ",");
        while (st.hasMoreElements()) {
         	 vatDetails=st.nextElement().toString().split("=");
			 if (vatDetails[0].trim().toLowerCase().equalsIgnoreCase("vat_number")) {
				this.vatNumber=vatDetails[1];
			 }
			 else if (vatDetails[0].trim().toLowerCase().equalsIgnoreCase("country_code")) {
					this.countryCode=vatDetails[1].substring(0, vatDetails[1].length()-1);
				 }

        }
	}
	
	/**
	 * Getters and setters
	 * @return {@link String} : country code ID
	 */
	public String getCountryCode() {
		return countryCode;
	}
	/**
	 * 
	 * @param countryCode : Set country code ID
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	/**
	 * @return {@link String} : VAT number
	 */
	public String getVatNumber() {
		return vatNumber;
	}
	/**
	 * 
	 * @param vatNumber : Set VAt number value
	 */
	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}
}
