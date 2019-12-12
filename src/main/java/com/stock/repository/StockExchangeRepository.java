package com.stock.repository;

import com.stock.domain.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockExchangeRepository extends JpaRepository<StockExchange,Long> {
    public StockExchange findById(long id);


}
