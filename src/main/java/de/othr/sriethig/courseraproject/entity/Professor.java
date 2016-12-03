/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.base.AbstractUser;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author sonja
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Professor extends AbstractUser {

    @OneToMany(mappedBy="professor", cascade={CascadeType.PERSIST})
    @Getter @Setter private Collection<Course> courses;
    
    /**
     * 
     * @param course
     * @return 
     */
    public Professor addCourse(Course course) {
        if(!courses.contains(course)) {
            courses.add(course);
        }
        return this;
    }
    
    /**
     * 
     * @param course
     * @return 
     */
    public Professor removeCourse(Course course) {
        if(courses.contains(course)) {
            courses.remove(course);
        }
        return this;
    }
    
}
