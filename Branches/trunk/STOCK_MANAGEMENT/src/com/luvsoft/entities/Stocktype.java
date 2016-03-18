package com.luvsoft.entities;

// Generated Feb 16, 2016 10:53:47 PM by Hibernate Tools 4.3.1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.luvsoft.utils.NemErrorList;
import com.luvsoft.view.component.anotations.AvoidDuplication;

/**
 * Stocktype generated by hbm2java
 */
@Entity
@Table(name = "stocktype", catalog = "stockmanagement", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Stocktype extends AbstractEntity implements java.io.Serializable {

    private static final long serialVersionUID = -2767774978183348478L;
    private Integer id;
    private String name;
    private String description;
    private Set<Stock> stocks = new HashSet<Stock>(0);

    public Stocktype() {
        id=-1;
        name="";
        description="";
    }

    public Stocktype(String name) {
        this.name = name;
    }

    public Stocktype(String name, String description, Set<Stock> stocks) {
        this.name = name;
        this.description = description;
        this.stocks = stocks;
    }

    public Stocktype(Integer id, String name, String description, Set<Stock> stocks) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stocks = stocks;
    }

    @Override
    public Stocktype cloneObject() {
        return new Stocktype(getId(), getName(), getDescription(), getStocks());
    }

    @Override
    public void verifyObject() {
        if(id == null) {
            id = -1;
        }
        if(name == null) {
            name = "";
        }
        if(description == null) {
            description = "";
        }
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

    @Column(name = "name", unique = true, nullable = false, length = 45)
    @Length(max = 45, message = NemErrorList.Error_NameTooLong)
    @NotBlank(message = NemErrorList.Error_NameNotEmpty)
    @AvoidDuplication(message = NemErrorList.Error_NameIsDuplicated)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Length(max = 65535, message = NemErrorList.Error_DescriptionTooLong)
    @Column(name = "description", length = 65535)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "stocktype")
    public Set<Stock> getStocks() {
        return this.stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }

    @Override
    public String toString() {
//        return "Stocktype [id=" + id + ", name=" + name + ", description="
//                + description + ", stocks=" + stocks + "]";
        return name;
    }

    public static String getEntityname() {
        return "Stocktype";
    }

    @Override
    public Object getValueByPropertyName(String propertyName) {
        switch (propertyName) {
            case "name":
                return this.name;
            case "description":
                return this.description;
        }
        return new String("Not found");
    }
}
