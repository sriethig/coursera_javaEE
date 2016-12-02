/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.model;

import de.othr.sriethig.courseraproject.control.CourseService;
import de.othr.sriethig.courseraproject.entity.Course;
import de.othr.sriethig.courseraproject.entity.SCStudent;
import de.othr.sriethig.courseraproject.entity.base.AbstractStudent;
import java.io.Serializable;
import java.util.List;
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
public class StudentModel implements Serializable {
    
    @Getter @Setter private AbstractStudent student;
    @Getter @Setter private List<Course> courses;
    @Getter @Setter private List<Course> availableCourses;
    
    @Getter @Setter private String searchTag;
     
    @Inject
    LoginModel loginModel;
    
    @Inject
    CourseService courseService;
    
    /**
     * 
     */
    public void initialize() {
        student = (AbstractStudent) loginModel.getAbstractUser();
        
        // list all courses of the user
        courses = (List<Course>) student.getCourses();
        
        // list all available courses
        availableCourses = 
                courseService.getAllCourses();
    }
    
    /**
     * 
     */
    public void searchForCourses() {
            List<Course> resultCourses = 
                courseService.findCoursesByTag("%" + this.searchTag + "%");
        availableCourses = resultCourses;
    }
    
    /**
     * 
     * @param course 
     */
    public void enrollInCourse(Course course) {
        if(!this.student.getCourses().contains(course)) {
            this.student.addCourse(course);
        }
    } 
    
    /**
     * 
     * @param course 
     */
    public void unenrollFromCourse(Course course) {
        if(this.student.getCourses().contains(course)) {
            this.student.removeCourse(course);
        }
    }
    
}
