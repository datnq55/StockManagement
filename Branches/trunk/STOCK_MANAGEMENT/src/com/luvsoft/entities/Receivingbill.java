package com.luvsoft.entities;

// Generated Apr 17, 2016 5:39:08 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Receivingbill generated by hbm2java
 */
@Entity
@Table(name = "receivingbill", catalog = "stockmanagement")
public class Receivingbill extends AbstractEntity implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 996658298117657862L;
    private Integer id;
    private String code;
    private Customer customer;
    private String content;
    private Date date;
    private String note;
    private Integer idOrder;
    private Integer idCoupon;
    private Set<Receivingbilldetail> receivingbilldetails = new HashSet<Receivingbilldetail>(0);

    public Receivingbill() {
    }

    public Receivingbill(Customer customer, String code, String content, Date date) {
        this.customer = customer;
        this.code = code;
        this.content = content;
        this.date = date;
    }

    public Receivingbill(String code, Customer customer, String content, Date date, String note, Integer idOrder, Integer idCoupon,
            Set<Receivingbilldetail> receivingbilldetails) {
        this.code = code;
        this.customer = customer;
        this.content = content;
        this.date = date;
        this.note = note;
        this.idOrder = idOrder;
        this.idCoupon = idCoupon;
        this.receivingbilldetails = receivingbilldetails;
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

    @Column(name = "code", nullable = false, length = 45)
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCustomer", nullable = false)
    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Column(name = "content", nullable = false, length = 65535)
    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false, length = 19)
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "note", length = 65535)
    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Column(name = "idOrder")
    public Integer getIdOrder() {
        return this.idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    @Column(name = "idCoupon")
    public Integer getIdCoupon() {
        return this.idCoupon;
    }

    public void setIdCoupon(Integer idCoupon) {
        this.idCoupon = idCoupon;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "receivingbill", cascade=CascadeType.ALL)
    public Set<Receivingbilldetail> getReceivingbilldetails() {
        return this.receivingbilldetails;
    }

    public void setReceivingbilldetails(Set<Receivingbilldetail> receivingbilldetails) {
        this.receivingbilldetails = receivingbilldetails;
    }

    @Override
    public String toString() {
        return "Receivingbill [id=" + id + ", coupon=" + idCoupon + ", customer="
                + customer + ", order=" + idOrder + ", code=" + code
                + ", content=" + content + ", date=" + date + ", note=" + note
                + ", receivingbilldetails=" + receivingbilldetails + "]";
    }

    public static String getEntityname() {
        return "Receivingbill";
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
