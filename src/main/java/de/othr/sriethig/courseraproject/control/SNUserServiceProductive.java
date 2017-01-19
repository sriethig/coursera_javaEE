/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.control;

import de.othr.sriethig.courseraproject.entity.SNStudent;
import de.othr.sriethig.courseraproject.service.ISNUserService;

/**
 *
 * @author sonja
 */
public class SNUserServiceProductive implements ISNUserService {

    @Override
    public SNStudent authenticateSNUser(String nickname, String password) {
        SNStudent student = new SNStudent();
        return student;
    }
    
}
