/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.model;

import de.othr.sriethig.courseraproject.control.CourseService;
import de.othr.sriethig.courseraproject.control.StudentService;
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
    
    @Getter @Setter private Course detailCourse;
     
    @Inject
    LoginModel loginModel;
    
    @Inject
    CourseModel courseModel;
    
    @Inject
    StudentService studentService;
    
    @Inject
    CourseService courseService;
    
    
    /**
     * 
     */
    public void initialize() {
        // list all courses of the user
        courses = studentService.getEnrolledCourses(this.student);
        
        // list all available courses
        availableCourses = 
                courseService.getAllCourses();
        
        detailCourse = null;
        
        // initialize result list
        searchForCourses();
    }
    
    /**
     * 
     */
    public void searchForCourses() {
            resultCourses = 
                courseService.findCoursesByTag("%" + this.searchTag + "%");
    }
    
    /**
     * 
     * @param course
     * @return 
     */
    public boolean isInSearchedCourses(Course course) {
        if(resultCourses == null) {
            return false;
        } else if(resultCourses.contains(course)) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * 
     * @param course 
     */
    public void enrollInCourse(Course course) {
        if(!studentService.getEnrolledCourses(this.student).contains(course)) {
            courseService.addStudent(course, this.student);
        }
        this.courses = studentService.getEnrolledCourses(this.student);
    } 
    
    /**
     * 
     * @param course 
     */
    public void unenrollFromCourse(Course course) {
        if(studentService.getEnrolledCourses(this.student).contains(course)) {
            courseService.removeStudent(course, this.student);
        }
        this.courses = studentService.getEnrolledCourses(this.student);
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
    
    public String showDetailCourse(Course course) {
        //this.detailCourse = course;
        courseModel.setCourse(course);
        System.out.println("showing detail course: " + course.getTitle());
        return "show_course.xhtml";
    }
    
}
