/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.control;

import de.othr.sriethig.courseraproject.entity.BookProxy;
import de.othr.sriethig.courseraproject.service.IBookService;
import de.othr.sriethig.courseraproject.util.BookServiceProductiveAnnotation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author sonja
 */
@BookServiceProductiveAnnotation
@RequestScoped
public class BookServiceProductive implements IBookService, Serializable {

    @Override
    public List<BookProxy> getBooksForCourse(String tag) {
        List<BookProxy> books = new ArrayList<>();
        try { // Call Web Service Operation
            services.impl.BookServiceService service = new services.impl.BookServiceService();
            services.impl.BookService port = service.getBookServicePort();
            
            // TODO initialize WS operation arguments here
            java.lang.String arg0 = tag;
            // TODO process result here
            java.util.List<services.impl.AbstractBook> result = port.searchBooks(arg0);
            if(result.isEmpty()) {
                books = null;
            } else {
                for(services.impl.AbstractBook book : result) {
                    BookProxy tempBook = new BookProxy(
                            book.getIsbn(), book.getName(),
                            authorsAsString(book.getAuthor()), 
                            book.getPrice());
                    books.add(tempBook);
                }
            }
            
            return books;
            
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            return null;
        }
    }
 
    /**
     * 
     * @param authorList
     * @return 
     */
    public String authorsAsString(List<services.impl.Author> authorList) {
        return authorList.stream().map(a -> (a.getFirstName() + " " + a.getLastName())).collect(Collectors.joining(", "));
    }
}
