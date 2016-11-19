/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.base.AbstractUser;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author sonja
 */
@Entity
public class Professor extends AbstractUser {

    @OneToMany(mappedBy="professor")
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
