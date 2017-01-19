/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author sonja
 */
@AllArgsConstructor
@NoArgsConstructor
public class BookProxy {
    
    @Getter @Setter private String isbn;
    @Getter @Setter private String name;
    @Getter @Setter private String author;
    @Getter @Setter private BigDecimal price;
    
}
