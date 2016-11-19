/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.base.AbstractStudent;
import de.othr.sriethig.courseraproject.entity.base.SingleIdEntity;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author sonja
 */
@Entity
public class Course extends SingleIdEntity {

    private String courseTitle;
    private String courseDescription;
    
    @ManyToOne
    private Professor professor;
    
    @ManyToMany
    private Collection<AbstractStudent> students;
    
    @OneToMany(mappedBy="course")
    private Collection<Lesson> lessons;

    /**
     * 
     */
    public Course() {
    }

    /**
     * 
     * @return 
     */
    public String getCourseTitle() {
        return courseTitle;
    }

    /**
     * 
     * @param courseTitle 
     */
    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    /**
     * 
     * @return 
     */
    public String getCourseDescription() {
        return courseDescription;
    }

    /**
     * 
     * @param courseDescription 
     */
    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
    
    

    /**
     * 
     * @return 
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * 
     * @param professor 
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    /**
     * 
     * @return 
     */
    public Collection<AbstractStudent> getStudents() {
        return students;
    }

    /**
     * 
     * @param students 
     */
    public void setStudents(Collection<AbstractStudent> students) {
        this.students = students;
    }
    
    /**
     * 
     * @param student 
     */
    public void addStudent(AbstractStudent student) {
        this.students.add(student);
    }

    /**
     * 
     * @return 
     */
    public Collection<Lesson> getLessons() {
        return lessons;
    }

    /**
     * 
     * @param lessons 
     */
    public void setLessons(Collection<Lesson> lessons) {
        this.lessons = lessons;
    }
    
    /**
     * 
     * @param lesson 
     */
    public void addLesson(Lesson lesson) {
        this.lessons.add(lesson);
    }
    
}
