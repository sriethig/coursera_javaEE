/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javax.faces.convert;

import de.othr.sriethig.courseraproject.control.AbstractUserService;
import de.othr.sriethig.courseraproject.entity.base.SingleIdEntity;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.NoArgsConstructor;

/**
 *
 * @author sonja
 */
@Named
@RequestScoped
@NoArgsConstructor
public class UserConverter extends AbstractConverter {

    @Inject
    private AbstractUserService abstractUserService;
    
    @Override
    public SingleIdEntity find(Long id) {
        return abstractUserService.findById(id);
    }
    
}
