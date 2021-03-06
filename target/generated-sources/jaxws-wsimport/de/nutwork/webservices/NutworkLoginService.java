
package de.nutwork.webservices;

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
@WebService(name = "NutworkLoginService", targetNamespace = "webservices.nutwork.de")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface NutworkLoginService {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns de.nutwork.webservices.SndtoUser
     * @throws InvalidPasswordException_Exception
     * @throws NotFoundException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "login", targetNamespace = "webservices.nutwork.de", className = "de.nutwork.webservices.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "webservices.nutwork.de", className = "de.nutwork.webservices.LoginResponse")
    public SndtoUser login(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1)
        throws InvalidPasswordException_Exception, NotFoundException_Exception
    ;

}
