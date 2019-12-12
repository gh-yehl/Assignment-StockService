package com.stock.domain;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "stockexchange")
public class StockExchange implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "stockexchange", nullable = false)
    private String stockExchange;

    @Column(name = "brief", nullable = false)
    private String brief;

    @Column(name = "contactaddress", nullable = false)
    private String contactAddress;

    @Column(name = "remarks", nullable = false)
    private String remarks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(String stockExchange) {
        this.stockExchange = stockExchange;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
