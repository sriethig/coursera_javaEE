/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.control;

import de.othr.sriethig.courseraproject.entity.BookProxy;
import de.othr.sriethig.courseraproject.service.IBookService;
import de.othr.sriethig.courseraproject.util.BookServiceTestAnnotation;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author sonja
 * proxy for beta testing BookService
 */
@BookServiceTestAnnotation
@RequestScoped
public class BookServiceTest implements IBookService, Serializable {

    @Override
    public List<BookProxy> getBooksForCourse(String tag) {
        List<BookProxy> books = new ArrayList<>();
        BookProxy testBook = new BookProxy("ISBN", "N/A", "N/A", 
                BigDecimal.valueOf(0.00));  
        books.add(testBook);
        return books;
    }
    
}
