/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.model;

import de.othr.sriethig.courseraproject.control.CourseService;
import de.othr.sriethig.courseraproject.control.ProfessorService;
import de.othr.sriethig.courseraproject.entity.Course;
import de.othr.sriethig.courseraproject.entity.Professor;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sonja
 */
@Named
@SessionScoped
public class ProfessorModel implements Serializable {
    
    @Getter @Setter private Professor professor;
    @Getter @Setter private List<Course> courses;
    
    @Getter @Setter private String title;
    @Getter @Setter private String description;

    
    @Inject
    private CourseModel courseModel;
    
    @Inject
    private CourseService courseService;
    
    @Inject
    private ProfessorService professorService;
    
    /**
     * 
     */
    public void initialize() {
        // list all courses of the user
        this.courses = professorService.getCourses(this.professor);
    }
    
    /**
     * 
     */
    public void addCourse() {    
        Course course = new Course();
        course.setTitle(this.title);
        course.setDescription(this.description);
                
        course = courseService.createCourse(course);
        courseService.addProfessor(course, this.professor);
        
        this.courses = professorService.getCourses(this.professor);
    }
    
    /**
     * 
     * @param course 
     */
    public void removeCourse(Course course) {
        courseService.removeCourse(course);
        this.courses = professorService.getCourses(this.professor);
    }
    
    /**
     * 
     * @param course 
     * @return  
     */
    public String editCourse(Course course) {
        courseModel.setCourse(course);
        return "editCourse";
    }
}