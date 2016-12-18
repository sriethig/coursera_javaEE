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
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
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
@RequestScoped
public class StudentModel implements Serializable {
    
    @Getter @Setter private AbstractStudent student;
    
    @Getter @Setter private List<Course> courses;
    @Setter private List<Course> availableCourses;
    @Getter @Setter private List<Course> resultCourses;
    
    @Getter @Setter private String searchTag = "";
    
    @Getter @Setter private Course detailCourse;
     
    @Inject
    private LoginModel loginModel;
    
    /*@Inject
    private CourseModel courseModel;*/
    
    @Inject
    private StudentService studentService;
    
    @Inject
    private CourseService courseService;
    
    
    /**
     * 
     */
    @PostConstruct
    public void initialize() {
        // list all courses of the user
        this.student = (AbstractStudent) loginModel.getAbstractUser();
        this.courses = null; //studentService.getEnrolledCourses(this.student);
        
        // list all available courses
        availableCourses = null;
                //courseService.getAllCourses();
        
        detailCourse = null;
        
        // initialize result list
        searchForCourses();
    }
    
    /**
     * get all courses from server when page is initialized
     * @return 
     */
    public List<Course> getAvailableCourses() {  
        //this.availableCourses = courseService.getAllCourses();  
        return this.availableCourses;
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
        /*if(!studentService.getEnrolledCourses(this.student).contains(course)) {
            System.out.println("StudentModel::enrollInCourse -> " + this.student.getName() + " -> " + course.getTitle());
            //course = courseService.addStudent(course, this.student);
            this.student = studentService.enrollInCourse(this.student, course);
        }
        this.courses = studentService.getEnrolledCourses(this.student);*/
    } 
    
    /**
     * 
     * @param course 
     */
    public void unenrollFromCourse(Course course) {
        /*if(studentService.getEnrolledCourses(this.student).contains(course)) {
            //course = courseService.removeStudent(course, this.student);
            this.student = studentService.unenrollFromCourse(this.student, course);
        }
        this.courses = studentService.getEnrolledCourses(this.student);*/
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
    
    /**
     * 
     * @param course
     * @return 
     */
    public String showDetailCourse(Course course) {
        this.detailCourse = course;
        //courseModel.initialize();
        System.out.println("StudentModel::detailCourse: " + this.detailCourse.getTitle());
        this.searchTag = "";
        return "show_course";
    }
    
}
