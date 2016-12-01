/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.model;

import de.othr.sriethig.courseraproject.entity.SCStudent;
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
public class SCStudentModel implements Serializable {
    
    @Getter @Setter private String studentFirstName; 
     
    @Inject
    LoginModel loginModel;
    
    /**
     * 
     */
    public void initialize() {
        SCStudent student = (SCStudent)loginModel.getAbstractUser();
        this.studentFirstName = student.getFirstName();
    }
    
}
