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
 * Orderdetail generated by hbm2java
 */
@Entity
@Table(name = "orderdetail", catalog = "stockmanagement")
public class Orderdetail extends AbstractEntity implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -2791696496009521630L;
    private Integer id;
    private Material material;
    private Order order;
    private int quantityNeeded;
    private int quantityDelivered;
    private BigDecimal price;
    private Integer saleOff;

    public Orderdetail() {
    }

    public Orderdetail(Material material, Order order, int quantityNeeded, int quantityDelivered, BigDecimal price) {
        this.material = material;
        this.order = order;
        this.quantityNeeded = quantityNeeded;
        this.quantityDelivered = quantityDelivered;
        this.price = price;
    }

    public Orderdetail(Material material, Order order, int quantityNeeded, int quantityDelivered, BigDecimal price, Integer saleOff) {
        this.material = material;
        this.order = order;
        this.quantityNeeded = quantityNeeded;
        this.quantityDelivered = quantityDelivered;
        this.price = price;
        this.saleOff = saleOff;
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
    @JoinColumn(name = "idMaterial", nullable = false)
    public Material getMaterial() {
        return this.material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idOrder", nullable = false)
    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Column(name = "quantityNeeded", nullable = false)
    public int getQuantityNeeded() {
        return this.quantityNeeded;
    }

    public void setQuantityNeeded(int quantityNeeded) {
        this.quantityNeeded = quantityNeeded;
    }

    @Column(name = "quantityDelivered", nullable = false)
    public int getQuantityDelivered() {
        return this.quantityDelivered;
    }

    public void setQuantityDelivered(int quantityDelivered) {
        this.quantityDelivered = quantityDelivered;
    }

    @Column(name = "price", nullable = false, scale = 4)
    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "saleOff")
    public Integer getSaleOff() {
        return this.saleOff;
    }

    public void setSaleOff(Integer saleOff) {
        this.saleOff = saleOff;
    }

    @Override
    public String toString() {
        return "Orderdetail [id=" + id + ", material=" + material + ", order="
                + order + ", quantityNeeded=" + quantityNeeded
                + ", quantityDelivered=" + quantityDelivered + ", price="
                + price + ", saleOff=" + saleOff + "]";
    }

    public static String getEntityname() {
        return "Orderdetail";
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
