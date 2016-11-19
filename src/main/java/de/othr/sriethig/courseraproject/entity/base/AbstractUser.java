/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.entity.base;

import de.othr.sriethig.courseraproject.entity.Address;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

/**
 *
 * @author sonja
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractUser extends SingleIdEntity {
    
    private String firstName;
    private String name;
    
    @OneToOne(cascade = {CascadeType.PERSIST})
    private Address address;

    /**
     * 
     */
    public AbstractUser() {
    }

    /**
     * 
     * @return 
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @param firstName 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return 
     */
    public Address getAddress() {
        return address;
    }

    /**
     * 
     * @param address 
     */
    public void setAddress(Address address) {
        this.address = address;
    }
    
    
    
}
