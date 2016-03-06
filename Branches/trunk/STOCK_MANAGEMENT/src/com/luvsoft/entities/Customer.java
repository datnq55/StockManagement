package com.luvsoft.entities;

// Generated Jan 26, 2016 10:06:12 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Customer generated by hbm2java
 */
@Entity
@Table(name = "customer", catalog = "stockmanagement")
public class Customer extends AbstractEntity implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 7073372847951568596L;
    private Integer id;
    private Area area;
    private Customertype1 customertype1;
    private Customertype2 customertype2;
    private String code;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String bankName;
    private String bankAccount;
    private BigDecimal debt;
    private Set<Order> orders = new HashSet<Order>(0);
    private Set<Spendingbill> spendingbills = new HashSet<Spendingbill>(0);
    private Set<Coupon> coupons = new HashSet<Coupon>(0);
    private Set<Receivingbill> receivingbills = new HashSet<Receivingbill>(0);

    public Customer() {
    }

    public Customer(String code, String name, BigDecimal debt) {
        this.code = code;
        this.name = name;
        this.debt = debt;
    }

    public Customer(Area area, Customertype1 customertype1, Customertype2 customertype2, String code, String name, String address,
            String phoneNumber, String email, String bankName, String bankAccount, BigDecimal debt, Set<Order> orders,
            Set<Spendingbill> spendingbills, Set<Coupon> coupons, Set<Receivingbill> receivingbills) {
        this.area = area;
        this.customertype1 = customertype1;
        this.customertype2 = customertype2;
        this.code = code;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.bankName = bankName;
        this.bankAccount = bankAccount;
        this.debt = debt;
        this.orders = orders;
        this.spendingbills = spendingbills;
        this.coupons = coupons;
        this.receivingbills = receivingbills;
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
    @JoinColumn(name = "idArea")
    public Area getArea() {
        return this.area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCustomerType1")
    public Customertype1 getCustomertype1() {
        return this.customertype1;
    }

    public void setCustomertype1(Customertype1 customertype1) {
        this.customertype1 = customertype1;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCustomerType2")
    public Customertype2 getCustomertype2() {
        return this.customertype2;
    }

    public void setCustomertype2(Customertype2 customertype2) {
        this.customertype2 = customertype2;
    }

    @Column(name = "code", nullable = false, length = 45)
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "name", nullable = false, length = 128)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "address", length = 65535)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "phoneNumber", length = 20)
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "email", length = 256)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "bankName", length = 256)
    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Column(name = "bankAccount", length = 45)
    public String getBankAccount() {
        return this.bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Column(name = "debt", nullable = false, scale = 4)
    public BigDecimal getDebt() {
        return this.debt;
    }

    public void setDebt(BigDecimal debt) {
        this.debt = debt;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    public Set<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    public Set<Spendingbill> getSpendingbills() {
        return this.spendingbills;
    }

    public void setSpendingbills(Set<Spendingbill> spendingbills) {
        this.spendingbills = spendingbills;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    public Set<Coupon> getCoupons() {
        return this.coupons;
    }

    public void setCoupons(Set<Coupon> coupons) {
        this.coupons = coupons;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    public Set<Receivingbill> getReceivingbills() {
        return this.receivingbills;
    }

    public void setReceivingbills(Set<Receivingbill> receivingbills) {
        this.receivingbills = receivingbills;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", area=" + area + ", customertype1="
                + customertype1 + ", customertype2=" + customertype2
                + ", code=" + code + ", name=" + name + ", address=" + address
                + ", phoneNumber=" + phoneNumber + ", email=" + email
                + ", bankName=" + bankName + ", bankAccount=" + bankAccount
                + ", debt=" + debt + ", orders=" + orders + ", spendingbills="
                + spendingbills + ", coupons=" + coupons + ", receivingbills="
                + receivingbills + "]";
    }

    public static String getEntityname() {
        return "Customer";
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
