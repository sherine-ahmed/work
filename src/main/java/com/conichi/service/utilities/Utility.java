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
 * Utility handle string parsed in currency conversion
 */
public class Utility {
	/**
	 * Default constructor
	 */
	public Utility() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param fromCurrency :Type of currency provided from
	 * @param toCurrency : Type of currency want to transfer
	 * @param quantity :quantity to be transferred 
	 * @return {@link Boolean} : Status of ID valid or not
	 */
	public double CurrencyParsingStringUtility (String fromCurrency, String toCurrency, double quantity) {
	
	String entryKey="";
	String resultConversion="";
	//create ObjectMapper instance
	ObjectMapper objectMapper = new ObjectMapper();

	//convert json file to map
	HashMap<String, String> map=new HashMap<String, String>();
	try {
		map = objectMapper.readValue(new FileInputStream("src/main/resources/currencyFullResponse.json"), HashMap.class);
	} catch (IOException e) {
		System.out.println("Issue while parsing JSON file");
		e.printStackTrace();
	}//Process Key value pair
	for (Map.Entry<?, ?> entry : map.entrySet()) {
	    entryKey=entry.getKey().toString();
	    if (entryKey.equalsIgnoreCase("quotes")) {
	    	resultConversion=entry.getValue().toString();	    	
	    }
	 
	}
	return parsingOutputResult(fromCurrency, toCurrency, quantity, resultConversion);
}

	/**
	 * 
	 * @param from :Currency type provided
	 * @param to :Currency type to be transferred
	 * @param quantity :quantity to be transferred
	 * @param rates : List of the rates values in Key/Value pair
	 * @return {@link Double} : value after transfer and calculation
	 */
	public double parsingOutputResult(String from , String to , double quantity,String rates){
	
	 double result=0;
	 double fromValue = 0;
	 double toValue=0;
	 String [] currencyString;
	 int catchValues=0;
	 //Tokenize string to get rate of transfer
	 StringTokenizer st = new StringTokenizer(rates, ",");
     while (st.hasMoreElements()) {
			 currencyString=st.nextElement().toString().split("=");
			 if (currencyString[0].trim().toLowerCase().equalsIgnoreCase(from.trim().toLowerCase())) {
				 catchValues++;
				 fromValue=Double.valueOf(currencyString[1]); 
			 }
			 else if (currencyString[0].trim().toLowerCase().equalsIgnoreCase(to.trim().toLowerCase())) {
				  catchValues++;
				  toValue=Double.valueOf(currencyString[1]);
			 }
			 if (catchValues==2) //No need to continue parsing items once the values requested existing
					 break;
	  }
     //Do Math  calculation
       if(fromValue!=0)
    	   result=(quantity/fromValue)*toValue;
	   return  result;
	}
}