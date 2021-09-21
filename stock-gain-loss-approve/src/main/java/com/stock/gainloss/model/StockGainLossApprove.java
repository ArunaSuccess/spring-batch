package com.stock.gainloss.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_STOCKS_GNLS_APPROVED")
public class StockGainLossApprove {
	
	@Id
	private String ticker;
	private boolean approve;
	
	
	public StockGainLossApprove() {
		
	}
	
	public StockGainLossApprove(String ticker, boolean approve) {
		super();
		this.ticker = ticker;
		this.approve = approve;
	}
	
	
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public boolean isApprove() {
		return approve;
	}
	public void setApprove(boolean approve) {
		this.approve = approve;
	}

	@Override
	public String toString() {
		return "StockGainLossApprove [ticker=" + ticker + ", approve=" + approve + "]";
	}
	
	
	

}
