/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.service;

import java.util.List;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author sonja
 */
public interface ISNGroupService {
    
    public List<Long> getStudentsInTheSameCourseAs(Long socialMediaId)
            throws NotFoundException;
    
}
