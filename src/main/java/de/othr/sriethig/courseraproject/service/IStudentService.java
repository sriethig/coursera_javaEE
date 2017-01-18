/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.service;

import java.util.List;

/**
 *
 * @author sonja
 */
//@WebService
public interface IStudentService {
    
    public List<String> getStudentsInTheSameCourseAs(String snStudentNickname);
    
}
