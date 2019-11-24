package com.conichi.service.beans;

/**
 * 
 * @author Sherine.Emad
 * Bean hold VAT attributes
 */

public class VATValidationBean {

	 private String countryCode; //Country code of the provided VAT_ID
	 private String  vatNumber; //VAT number as per the given VAT_ID
	 private boolean isValid; // Status of the VAT_ID valid or not
	 
	/**
	 * Constructor
	 */
	public VATValidationBean() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Parameterized Constructor
	 * @param countryCode : Code of country as per VAT-ID
	 * @param vatNumber : VAT number as per VAT_ID
	 * @param isValid : Status of VAT_ID valid or not
	 */
	 public VATValidationBean(String countryCode, String vatNumber, boolean isValid) {
		    super();
		    this.countryCode = countryCode;
		    this.vatNumber = vatNumber;
		    this.isValid = isValid;
		   
	 }
	 /**
	  * Getters and setters for the bean attributes 
	  * @return {@link String} :country code
	  */
	 public String getCountryCode() {
		return countryCode;
	}
	 /**
	 * @param countryCode : Set the country code
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	 /**
	  * @return {@link String} :VAT number
	  */
	public String getVatNumber() {
		return vatNumber;
	}
	/**
	 * @param vatNumber : set VAT number
	 */
	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}
	 /**
	  * @return {@link Boolean} : staus of the ID
	  */
	public boolean isValid() {
		return isValid;
	}
	/**
	 * 
	 * @param isValid : set VAT_ID status valid or not
	 */
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	

}
