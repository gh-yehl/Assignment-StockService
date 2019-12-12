package com.stock.service;

import com.stock.domain.StockExchange;
import com.stock.model.StockExchangeDTO;
import com.stock.repository.StockExchangeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockExchangeService {

    @Autowired
    private StockExchangeRepository stockExchangeRepository;


    public void editStockExchange(StockExchangeDTO stockExchangeDTO) {
        StockExchange stockExchange = new StockExchange();
        BeanUtils.copyProperties(stockExchangeDTO, stockExchange);
        stockExchangeRepository.save(stockExchange);
    }

    public void addStockExchange(StockExchangeDTO stockExchange) {
        this.editStockExchange(stockExchange);
    }

    public void deleteStockExchange(long id) {
        stockExchangeRepository.deleteById(id);
    }


    public List<StockExchangeDTO> findAll() {
        List<StockExchange> list = stockExchangeRepository.findAll();
        List<StockExchangeDTO> dtoList = new ArrayList<StockExchangeDTO>();
        for (StockExchange stockExchange: list) {
            StockExchangeDTO stockExchangeDTO = new StockExchangeDTO();

            BeanUtils.copyProperties(stockExchange, stockExchangeDTO);
            dtoList.add(stockExchangeDTO);
        }
        return dtoList;
    }

}
