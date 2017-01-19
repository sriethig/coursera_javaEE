
package services.impl;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "BookService", targetNamespace = "http://Impl.Services/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BookService {


    /**
     * 
     * @return
     *     returns java.util.List<services.impl.AbstractBook>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findAll", targetNamespace = "http://Impl.Services/", className = "services.impl.FindAll")
    @ResponseWrapper(localName = "findAllResponse", targetNamespace = "http://Impl.Services/", className = "services.impl.FindAllResponse")
    public List<AbstractBook> findAll();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<services.impl.AbstractBook>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "searchBooks", targetNamespace = "http://Impl.Services/", className = "services.impl.SearchBooks")
    @ResponseWrapper(localName = "searchBooksResponse", targetNamespace = "http://Impl.Services/", className = "services.impl.SearchBooksResponse")
    public List<AbstractBook> searchBooks(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}