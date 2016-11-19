/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.base.SingleIdEntity;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author sonja
 */
@Entity
public class Professor extends SingleIdEntity {

    private String name;
    private String firstName;
    
    private Address address;
    
    @OneToMany(mappedBy="courseProfessor")
    private Collection<Course> courses;

    /**
     * 
     */
    public Professor() {
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

    /**
     * 
     * @return 
     */
    public Collection<Course> getCourses() {
        return courses;
    }

    /**
     * 
     * @param courses 
     */
    public void setCourses(Collection<Course> courses) {
        this.courses = courses;
    }
    
}
