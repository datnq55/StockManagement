package com.luvsoft.entities;

// Generated May 12, 2016 9:26:32 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.luvsoft.utils.Utilities;

/**
 * Customerhistory generated by hbm2java
 */
@Entity
@Table(name = "customerhistory", catalog = "stockmanagement")
public class Customerhistory extends AbstractEntity implements java.io.Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Customer customer;
    private BigDecimal debt;
    private Date date;

    public Customerhistory() {
        debt = new BigDecimal(0.00d);
        date = Utilities.StringToDate("1/1/2000 01:00:00");
    }

    public Customerhistory(Customer customer, BigDecimal debt, Date date) {
        this.customer = customer;
        this.debt = debt;
        this.date = date;
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
    @JoinColumn(name = "idCustomer", nullable = false)
    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Column(name = "debt", nullable = false, scale = 4)
    public BigDecimal getDebt() {
        return this.debt;
    }

    public void setDebt(BigDecimal debt) {
        this.debt = debt;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false, length = 19)
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public Object getValueByPropertyName(String propertyName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void verifyObject() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public AbstractEntity cloneObject() {
        // TODO Auto-generated method stub
        return null;
    }

    public static String getEntityname() {
        return "Customerhistory";
    }
}
