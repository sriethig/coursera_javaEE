/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.control;

import de.othr.sriethig.courseraproject.entity.Address;
import de.othr.sriethig.courseraproject.entity.Country;
import de.othr.sriethig.courseraproject.entity.SNStudent;
import de.othr.sriethig.courseraproject.service.ISNUserService;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author sonja
 */
public class SNUserServiceProductive implements ISNUserService, Serializable {
    
    @Inject
    private StudentService studentService;
    
    @Inject
    private Logger logger;

    @Override
    public SNStudent authenticateSNUser(String nickname, String password) {
        
        
        try { // Call Web Service Operation
            de.nutwork.webservices.LoginService service = new de.nutwork.webservices.LoginService();
            de.nutwork.webservices.NutworkLoginService port = service.getNutworkLoginServicePort();
            
            // TODO initialize WS operation arguments here
            java.lang.String arg0 = nickname;
            java.lang.String arg1 = password;
            
            // TODO process result here
            de.nutwork.webservices.SndtoUser result = port.login(arg0, arg1);
            
            SNStudent student = new SNStudent();
            student.setSocialMediaId(result.getId());
            student.setEmailAddress(nickname);
            student.setPassword(password);
            student.setFirstName(result.getFirstName());
            student.setName(result.getLastName());
            
            Address address = new Address(
                    "", 0, "Regensburg", Country.OTHER);
            
            student.setAddress(address);
            
            return student;
            
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            logger.log(Level.SEVERE, "Authentication with Nutwork failed: " + 
                    ex.getMessage());
            return null;
        }

    }
    
}
