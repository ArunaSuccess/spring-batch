package com.stock.gainloss.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.gainloss.model.StockGainLossApprove;

public interface StockGainLossRepository extends JpaRepository<StockGainLossApprove, String>{

}
