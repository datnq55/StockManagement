package com.luvsoft.entities;

// Generated Jan 26, 2016 10:06:12 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Spendingbilldetail generated by hbm2java
 */
@Entity
@Table(name = "spendingbilldetail", catalog = "stockmanagement")
public class Spendingbilldetail implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -2826810727454419030L;
    private Integer id;
    private Spendingbill spendingbill;
    private String category;
    private String reason;
    private BigDecimal amount;

    public Spendingbilldetail() {
    }

    public Spendingbilldetail(Spendingbill spendingbill, BigDecimal amount) {
        this.spendingbill = spendingbill;
        this.amount = amount;
    }

    public Spendingbilldetail(Spendingbill spendingbill, String category, String reason, BigDecimal amount) {
        this.spendingbill = spendingbill;
        this.category = category;
        this.reason = reason;
        this.amount = amount;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSpendingBill", nullable = false)
    public Spendingbill getSpendingbill() {
        return this.spendingbill;
    }

    public void setSpendingbill(Spendingbill spendingbill) {
        this.spendingbill = spendingbill;
    }

    @Column(name = "category", length = 256)
    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Column(name = "reason", length = 65535)
    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Column(name = "amount", nullable = false, scale = 4)
    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
