/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author sonja
 */
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
    
    @Getter @Setter private String street;
    @Getter @Setter private long zipCode;
    @Getter @Setter private String city;
    @Getter @Setter private Country country;

}
