package com.luvsoft.entities;

// Generated Jan 26, 2016 10:06:12 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Money generated by hbm2java
 */
@Entity
@Table(name = "money", catalog = "stockmanagement")
public class Money extends AbstractEntity implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 7060179423211748775L;
    private Integer id;
    private BigDecimal amount;
    private Date date;
    private String description;

    public Money() {
    }

    public Money(BigDecimal amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    public Money(BigDecimal amount, Date date, String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
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

    @Column(name = "amount", nullable = false, scale = 4)
    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false, length = 19)
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "description", length = 65535)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Money [id=" + id + ", amount=" + amount + ", date=" + date
                + ", description=" + description + "]";
    }

    public static String getEntityname() {
        return "Money";
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
}
