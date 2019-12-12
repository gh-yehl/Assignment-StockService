package com.stock.controller;

import com.stock.model.StockExchangeDTO;
import com.stock.service.StockExchangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@CrossOrigin(maxAge = 3600)
@RestController
public class StockExchangeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StockExchangeController.class);
    @Autowired
    private StockExchangeService stockExchangeService;

    public StockExchangeController(StockExchangeService stockExchangeService) {
        this.stockExchangeService = stockExchangeService;
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/getAllStockExchange", method = RequestMethod.GET)
    public List<StockExchangeDTO> getAllStockExchanges() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String token = request.getHeader("Authorization");

        LOGGER.info("service-stock  ==========>token:" + token);
        List<StockExchangeDTO> list = stockExchangeService.findAll();
        return list;
    }

    /**
     *
     * @param stockExchangeDTO
     * @return
     */
    @RequestMapping(value = "/addStockExchange", method = RequestMethod.POST)
    public StockExchangeDTO addStockExchange(@RequestBody StockExchangeDTO stockExchangeDTO) {
        stockExchangeService.addStockExchange(stockExchangeDTO);
        return stockExchangeDTO;
    }

    /**
     *
     * @param stockExchangeDTO
     * @return
     */
    @RequestMapping(value = "/editStockExchange", method = RequestMethod.POST)
    public StockExchangeDTO editStockExchange(@RequestBody StockExchangeDTO stockExchangeDTO) {
        stockExchangeService.editStockExchange(stockExchangeDTO);
        return stockExchangeDTO;
    }


    /**
     *
     * @param stockExchangeId
     * @return
     */
    @RequestMapping(value = "/deleteStockExchange", method = RequestMethod.GET)
    public String deleteStockExchange(@RequestParam("stockExchangeId") String stockExchangeId) {
        stockExchangeService.deleteStockExchange(Long.valueOf(stockExchangeId));
        return "success";
    }
}
