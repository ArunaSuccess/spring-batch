package com.spring.batch.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.batch.dao.StockRepository;
import com.spring.batch.model.Stock;

@RestController
public class StockController {
	
	@Autowired
	StockRepository repo;
	
	@GetMapping("/stocks")
	public List<Stock> getAllStocks(){
		return repo.findAll();
	}

}
