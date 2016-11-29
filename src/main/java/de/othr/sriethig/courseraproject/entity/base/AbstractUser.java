/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.entity.base;

import de.othr.sriethig.courseraproject.entity.Address;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author sonja
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractUser extends SingleIdEntity {
    
    @Getter @Setter private String firstName;
    @Getter @Setter private String name;
    
    @OneToOne(cascade = {CascadeType.PERSIST})
    @Getter @Setter private Address address;

}
