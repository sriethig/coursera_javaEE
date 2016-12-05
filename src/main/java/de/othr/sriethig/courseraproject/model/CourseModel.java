/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.model;

import de.othr.sriethig.courseraproject.entity.Course;
import java.io.Serializable;
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
public class CourseModel implements Serializable {
    
    @Getter @Setter private Course course;
    
    @Inject
    LoginModel loginModel;
    
    @Inject
    StudentModel studentModel;
    
    public void initialize() {
    }
    
    public void enrollInThisCourse() {
        studentModel.enrollInCourse(course);
    }
    
    /**
     * 
     */
    public String goBack() {
        studentModel.setDetailCourse(null);
        return "student.xhtml";
    }
    
    public boolean enableEnrollInThisCourse() {
        return !studentModel.disableEnrollment(course);
    }
}
