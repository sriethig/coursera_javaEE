/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.util;

import java.util.logging.Logger;
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
public class LoggingProvider {
    
    @Produces
    public Logger createLogger(InjectionPoint injectionPoint) {
        String name = injectionPoint.getMember().getDeclaringClass().getCanonicalName();
        return Logger.getLogger(name);
    }
    
}
