package com.luvsoft.entities;

// Generated Jan 26, 2016 10:06:12 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Customertype1 generated by hbm2java
 */
@Entity
@Table(name = "customertype1", catalog = "stockmanagement")
public class Customertype1 implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 4954456262751517463L;
    private Integer id;
    private String name;
    private String description;
    private Set<Customer> customers = new HashSet<Customer>(0);

    public Customertype1() {
    }

    public Customertype1(String name) {
        this.name = name;
    }

    public Customertype1(String name, String description, Set<Customer> customers) {
        this.name = name;
        this.description = description;
        this.customers = customers;
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

    @Column(name = "name", nullable = false, length = 128)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", length = 65535)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customertype1")
    public Set<Customer> getCustomers() {
        return this.customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

}
