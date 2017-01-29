/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.control;

import de.othr.sriethig.courseraproject.entity.SNStudent;
import de.othr.sriethig.courseraproject.service.ISNUserService;
import java.io.Serializable;

/**
 *
 * @author sonja
 */
public class SNUserServiceTest implements ISNUserService, Serializable {

    @Override
    public SNStudent authenticateSNUser(String nickname, String password) {
        return null;
    }
    
}
