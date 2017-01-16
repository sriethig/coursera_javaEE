/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.base.SingleIdEntity;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
public class Lesson extends SingleIdEntity<Long> {

    @Getter @Setter private String title;
    @Getter @Setter private String lessonContent;
    
    @ManyToOne
    @Getter @Setter private Course course;
    
    @OneToOne
    @Getter @Setter private Video video;
  
    @OneToOne
    @Getter @Setter private Exam exam;
    
    /**
     * 
     * @param course
     * @return 
     */
    public Lesson addCourse(Course course) {
        this.course = course;
        return this;
    }
  
}
