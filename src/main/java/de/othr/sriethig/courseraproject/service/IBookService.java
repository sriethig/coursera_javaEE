/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.service;

import de.othr.sriethig.courseraproject.entity.BookProxy;
import java.util.List;

/**
 *
 * @author sonja
 */
public interface IBookService {
    
    public List<BookProxy> getBooksForCourse(String tag);
    
}
