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
 * Coupondetail generated by hbm2java
 */
@Entity
@Table(name = "coupondetail", catalog = "stockmanagement")
public class Coupondetail extends AbstractEntity implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 7046727495898933621L;
    private Integer id;
    private Coupon coupon;
    private Material material;
    private int quantity;
    private BigDecimal price;
    private Integer saleOff;

    public Coupondetail() {
    }

    public Coupondetail(Coupon coupon, Material material, int quantity, BigDecimal price) {
        this.coupon = coupon;
        this.material = material;
        this.quantity = quantity;
        this.price = price;
    }

    public Coupondetail(Coupon coupon, Material material, int quantity, BigDecimal price, Integer saleOff) {
        this.coupon = coupon;
        this.material = material;
        this.quantity = quantity;
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
    @JoinColumn(name = "idCoupon", nullable = false)
    public Coupon getCoupon() {
        return this.coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMaterial", nullable = false)
    public Material getMaterial() {
        return this.material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
        return "Coupondetail [id=" + id + ", coupon=" + coupon + ", material="
                + material + ", quantity=" + quantity + ", price=" + price
                + ", saleOff=" + saleOff + "]";
    }

    public static String getEntityname() {
        return "Coupondetail";
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

}
