/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.model;

import de.othr.sriethig.courseraproject.control.CourseService;
import de.othr.sriethig.courseraproject.entity.Course;
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
    @Getter @Setter private List<Course> resultCourses;
    
    @Getter @Setter private String searchTag = "";
     
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
        
        // initialize result list
        searchForCourses();
    }
    
    /**
     * 
     */
    public void searchForCourses() {
            resultCourses = 
                courseService.findCoursesByTag("%" + this.searchTag + "%");
            System.out.println("in searchForCourses ....size(): " + resultCourses.size());
    }
    
    /**
     * 
     * @param course
     * @return 
     */
    public boolean isInSearchedCourses(Course course) {
        /*System.out.println("isInSearchedCourses(" + course.getTitle() + ")");
        System.out.println("resultCourses.size(): " +resultCourses.size());*/
        if(resultCourses.contains(course)) {
            /*System.out.println("true");*/
            return true;
        } else {
            /*System.out.println("true");*/
            return false;
        }
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
    
    /**
     * 
     * @param course
     * @return 
     */
    public boolean disableEnrollment(Course course) {
        if(this.courses.contains(course)) {
            return true;
        } else {
            return false;
        }
    }
    
}
