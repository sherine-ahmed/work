package com.conichi.service.beans;

/**
 * 
 * @author Sherine.Emad
 * Currency Bean  hold the attributes required to be processed for currency conversion
 */
public class CurrencyConversionBean {

	  private String from; //attribute hold currency type want to transfer from 
	  private String to; //attribute hold currency type want to transfer to 
	  private double quantity; //attribute hold quantity want to transfer  
	  private double totalCalculatedAmount;//attribute hold value calculated after transfer 

	  /**
	   * constructor
	   */
	  public CurrencyConversionBean() {

	  }
	  /**
	   * constructor of the bean parameterized 
	   * @param from : Hold type of currency want to transfer from
	   * @param to : Hold type of currency want to transfer to 
	   * @param quantity : Hold quantity want to transfer 
	   * @param totalCalculatedAmount :Hold amount after transfer calculations
	   */
	  public CurrencyConversionBean(String from, String to, double quantity,double totalCalculatedAmount) {
	    super();
	    this.from = from;
	    this.to = to;
	    this.quantity = quantity;
	    this.totalCalculatedAmount = totalCalculatedAmount;
	  }

	  /**
	   * Setters and Getters for the Bean attributes
	   * @return {@link String} :from value
	   */
		
     public String getFrom() {
	    return from;
	  }

     /**
      * 
      * @param from : from type
      */
	  public void setFrom(String from) {
	    this.from = from;
	  }
	  /**
	   * @return {@link String} :to value
	   */
	  public String getTo() {
	    return to;
	  }
     /**
      * 
      * @param to : to type
      */
	  public void setTo(String to) {
	    this.to = to;
	  }
	  /**
	   * Setters and Getters for the Bean attributes
	   * @return {@link Double} :quantity to be transferred 
	   */
	  public double getQuantity() {
	    return quantity;
	  }
     /**
      * 
      * @param quantity : quantity value
      */
	  public void setQuantity(double quantity) {
	    this.quantity = quantity;
	  }
	  /**
	   * Setters and Getters for the Bean attributes
	   * @return {@link Double} :Calculated value after transfer
	   */
	  public double getTotalCalculatedAmount() {
	    return totalCalculatedAmount;
	  }
     /**
      * 
      * @param totalCalculatedAmount : amount after transfer and calculations
      */
	  public void setTotalCalculatedAmount(double totalCalculatedAmount) {
	    this.totalCalculatedAmount = totalCalculatedAmount;
	  }

	}