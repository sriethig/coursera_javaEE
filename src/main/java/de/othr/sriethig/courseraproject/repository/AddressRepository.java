/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.repository;

import de.othr.sriethig.courseraproject.entity.Address;
import de.othr.sriethig.courseraproject.repository.base.SingleIdEntityRepository;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author sonja
 */
@RequestScoped
public class AddressRepository extends
        SingleIdEntityRepository<Long, Address> implements Serializable {
    
    public AddressRepository() {
        super(Address.class);
    }
    
}
