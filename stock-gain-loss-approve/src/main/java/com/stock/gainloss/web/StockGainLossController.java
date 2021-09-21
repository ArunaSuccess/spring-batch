package com.stock.gainloss.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stock.gainloss.dao.StockGainLossRepository;
import com.stock.gainloss.model.StockGainLossApprove;

@RestController
public class StockGainLossController {
	
	@Autowired
	StockGainLossRepository gnlsRepo;
	
	
	@GetMapping("/stocks-gainloss")
	public List<StockGainLossApprove> getAllStocksGnls(){
		
			//Here I want to fetch the Stock details
			//Compare ReportedGnls to CalculatedGnls
			//If both are equal, set StockGnlsApprove.approve to "Yes"; else "No"
		return gnlsRepo.findAll();
	}

}
