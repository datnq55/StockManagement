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

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.luvsoft.utils.NemErrorList;
import com.luvsoft.view.component.anotations.AvoidDuplication;

/**
 * Materialtype1 generated by hbm2java
 */
@Entity
@Table(name = "materialtype1", catalog = "stockmanagement")
public class Materialtype1 extends AbstractEntity implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 4469553540623717561L;
    private Integer id;
    private String name;
    private String description;
    private Set<Material> materials = new HashSet<Material>(0);

    public Materialtype1() {
        id = -1;
        name = "";
        description = "";
    }

    public Materialtype1(String name) {
        this.name = name;
    }

    public Materialtype1(String name, String description, Set<Material> materials) {
        this.name = name;
        this.description = description;
        this.materials = materials;
    }

    
    public Materialtype1(Integer id, String name, String description,
            Set<Material> materials) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.materials = materials;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "materialtype1")
    public Set<Material> getMaterials() {
        return this.materials;
    }

    public void setMaterials(Set<Material> materials) {
        this.materials = materials;
    }

    @Override
    public String toString() {
        return name;
    }

    public static String getEntityname() {
        return "Materialtype1";
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
    
    @Override
    public Materialtype1 cloneObject() {
        return new Materialtype1(getId(), getName(), getDescription(), getMaterials());
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
}
