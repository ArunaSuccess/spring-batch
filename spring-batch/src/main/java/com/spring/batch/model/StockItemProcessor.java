package com.spring.batch.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class StockItemProcessor implements ItemProcessor<Stock, Stock> {
	
	private static final Logger log = LoggerFactory.getLogger(StockItemProcessor.class);

	  @Override
	  public Stock process(final Stock stock) throws Exception {
	    final String ticker = stock.getTicker();
	    final double boughtPrice = stock.getBoughtPrice();
	    final double shares = stock.getShares();
	    final double purchaseAmt = stock.getPurchaseAmt();
	    final double currentPrice = stock.getCurrentPrice();
	    final double glReported = stock.getGlReported();
	    final double glCalculated = stock.getGlCalculated();

	    final Stock transformedStock = new Stock(ticker, boughtPrice, shares, purchaseAmt, currentPrice, glReported, glCalculated);

	    log.info("Converting (" + stock+ ") into (" + transformedStock + ")");
	    
	    System.out.println("Stock row data ****" + ticker + " " + boughtPrice + " "+ shares +" ");

	    return transformedStock;
		  
//		  return stock;
	  }


}
