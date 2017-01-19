/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.util;

import de.othr.sriethig.courseraproject.control.SNUserServiceProductive;
import de.othr.sriethig.courseraproject.control.SNUserServiceTest;
import de.othr.sriethig.courseraproject.service.ISNUserService;
import de.othr.sriethig.courseraproject.util.SCConfig;
import java.io.Serializable;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import lombok.NoArgsConstructor;

/**
 *
 * @author sonja
 */
@Dependent
@NoArgsConstructor
public class SocialNutworkProvider implements Serializable {
    
    @Produces
    public ISNUserService createSNUserService(InjectionPoint injectionPoint) {
        String injectionPointName =
                injectionPoint.getMember().getDeclaringClass().getSimpleName();
        
        switch(SCConfig.getRunOption()) {
            case Test:
                return new SNUserServiceTest();
            case Productive:
                return new SNUserServiceProductive();
            default:
                return null;
        }
    }
    
}
