/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.service;

import de.othr.sriethig.courseraproject.entity.SNStudent;
import java.util.List;

/**
 *
 * @author sonja
 */
public interface IStudentService {
    
    public List<SNStudent> getStudentsInTheSameCourseAs(SNStudent SNStudent);
    public List<SNStudent> getStudentsInTheSameCourseAs(String nickName);
    
}
