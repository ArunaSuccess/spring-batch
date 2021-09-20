package com.spring.batch.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.batch.model.Stock;

public interface StockRepository extends JpaRepository<Stock, String>{

}
