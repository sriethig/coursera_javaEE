/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.base.AbstractStudent;
import de.othr.sriethig.courseraproject.entity.base.SingleIdEntity;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
public class Course extends SingleIdEntity {

    @Getter @Setter private String title;
    @Getter @Setter private String description;
    
    @ManyToOne(cascade={CascadeType.PERSIST})
    @Getter @Setter private Professor professor;
    
    @ManyToMany(cascade={CascadeType.PERSIST})
    @Setter private Collection<AbstractStudent> students;
    
    @OneToMany(mappedBy="course", cascade={CascadeType.PERSIST})
    @Setter private Collection<Lesson> lessons;
    
    /**
     * 
     * @return 
     */
    public List<AbstractStudent> getStudents() {
        return Collections.unmodifiableList((List<AbstractStudent>) this.students);
    }
    /**
     * 
     * @param student
     * @return 
     */
    public Course addStudent(AbstractStudent student) {
        if(!this.students.contains(student)) {
            this.students.add(student);
        }     
        return this;
    }
    
    /**
     * 
     * @param student
     * @return 
     */
    public Course removeStudent(AbstractStudent student) {
        if(this.students.contains(student)) {
            this.students.remove(student);
        }     
        return this;
    }
    
    /**
     * 
     * @param professor
     * @return 
     */
    public Course addProfessor(Professor professor) {
        this.professor = professor;    
        return this;
    }
    
    /**
     * 
     * @param professor
     * @return 
     */
    public Course updateProfessor(Professor professor) {
        this.professor = professor;    
        return this;
    }
    
    /**
     * 
     * @return 
     */
    public List<Lesson> getLessons() {
        return Collections.unmodifiableList((List<Lesson>) this.lessons);
    }
    
    /**
     * 
     * @param lesson
     * @return 
     */
    public Course addLesson(Lesson lesson) {
        if(!this.lessons.contains(lesson)) {
            this.lessons.add(lesson);
        }
        return this;
    }
    
    /**
     * 
     * @param lesson
     * @return 
     */
    public Course removeLesson(Lesson lesson) {
        if(this.lessons.contains(lesson)) {
            this.lessons.remove(lesson);
        }
        return this;
    }
}
