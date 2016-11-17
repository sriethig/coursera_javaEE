/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.base.SingleIdEntity;
import javax.persistence.Entity;

/**
 *
 * @author sonja
 */
@Entity
public class Address extends SingleIdEntity {
    
    private String street;
    private long zipCode;
    private String city;
    private Country country;

    /**
     * 
     */
    public Address() {
    }

    /**
     * 
     * @param street
     * @param zipCode
     * @param city
     * @param country 
     */
    public Address(String street, long zipCode, String city, Country country) {
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }

    /**
     * 
     * @return 
     */
    public String getStreet() {
        return street;
    }

    /**
     * 
     * @param street 
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * 
     * @return 
     */
    public long getZipCode() {
        return zipCode;
    }

    /**
     * 
     * @param zipCode 
     */
    public void setZipCode(long zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * 
     * @return 
     */
    public String getCity() {
        return city;
    }

    /**
     * 
     * @param city 
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 
     * @return 
     */
    public Country getCountry() {
        return country;
    }

    /**
     * 
     * @param country 
     */
    public void setCountry(Country country) {
        this.country = country;
    }
}
