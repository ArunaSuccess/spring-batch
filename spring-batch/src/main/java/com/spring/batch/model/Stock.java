package com.spring.batch.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity@Table(name="TBL_STOCKS")
public class Stock {
	
	@Id
	private String ticker;
	private double boughtPrice;
	private double shares;
	private double purchaseAmt;
	private double currentPrice;
	private double glReported;	
	private double glCalculated;
	
	
	public Stock () {
		
	}
	
	public Stock(String ticker, double boughtPrice, double shares, double purchaseAmt, double currentPrice, double glReported,
			double glCalculated) {
		super();
		this.ticker = ticker;
		this.boughtPrice = boughtPrice;
		this.shares = shares;
		this.purchaseAmt = purchaseAmt;
		this.currentPrice = currentPrice;
		this.glReported = glReported;
		this.glCalculated = glCalculated;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public double getBoughtPrice() {
		return boughtPrice;
	}
	public void setBoughtPrice(double boughtPrice) {
		this.boughtPrice = boughtPrice;
	}
	public double getShares() {
		return shares;
	}
	public void setShares(double shares) {
		this.shares = shares;
	}
	public double getPurchaseAmt() {
		return purchaseAmt;
	}
	public void setPurchaseAmt(double purchaseAmt) {
		this.purchaseAmt = purchaseAmt;
	}
	public double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public double getGlReported() {
		return glReported;
	}
	public void setGlReported(double glReported) {
		this.glReported = glReported;
	}
	public double getGlCalculated() {
		return glCalculated;
	}
	public void setGlCalculated(double glCalculated) {
		this.glCalculated = glCalculated;
	}
	
	@Override
	public String toString() {
		return "Stock [ticker=" + ticker + ", boughtPrice=" + boughtPrice + ", shares=" + shares + ", purchaseAmt="
				+ purchaseAmt + ", currentPrice=" + currentPrice + ", glReported=" + glReported + ", glCalculated="
				+ glCalculated + "]";
	}
	
	


}
