package com.stock.controller;

import com.stock.model.StockExchangeDTO;
import com.stock.service.StockExchangeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import static org.junit.Assert.*;


//@SpringBootTest
//@RunWith(SpringRunner.class)
public class StockExchangeControllerTest {
//
//    @Autowired
//    private StockExchangeService stockExchangeService;
//
//    private StockExchangeController stockExchangeController;
//
//    @Before
//    public void init() {
//        stockExchangeController = new StockExchangeController(stockExchangeService);
//    }
//
//
//    @Test
//    @Transactional
//    public void getAllSectors() {
//        List<StockExchangeDTO> list = stockExchangeController.getAllStockExchanges();
//        assertEquals(4, list.size());
//    }
//
//    @Test
//    public void addStockExchange() {
//        StockExchangeDTO stockExchangeDTO = new StockExchangeDTO();
//        stockExchangeDTO.setBrief("brief");
//        stockExchangeDTO.setContactAddress("addr");
//        stockExchangeDTO.setRemarks("remarks");
//        stockExchangeDTO.setStockExchange("stockExchange-junit-on");
//
//        StockExchangeDTO returnDTO = stockExchangeController.addStockExchange(stockExchangeDTO);
//
//        assertEquals("brief", returnDTO.getBrief());
//    }
//
//    @Test
//    public void editStockExchange() {
//        StockExchangeDTO stockExchangeDTO = new StockExchangeDTO();
//        stockExchangeDTO.setId(3);
//        stockExchangeDTO.setBrief("brief");
//        stockExchangeDTO.setContactAddress("addr");
//        stockExchangeDTO.setRemarks("remarks");
//        stockExchangeDTO.setStockExchange("stockExchange-junit-tw");
//
//        StockExchangeDTO returnDTO = stockExchangeController.editStockExchange(stockExchangeDTO);
//        assertEquals(3, returnDTO.getId());
//    }
//
//    @Test
//    public void deleteTechnology() {
//        String status = stockExchangeController.deleteStockExchange("363");
//        assertEquals("success", status);
//    }


}
