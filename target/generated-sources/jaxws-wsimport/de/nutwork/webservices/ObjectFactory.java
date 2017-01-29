
package de.nutwork.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.nutwork.webservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LoginResponse_QNAME = new QName("webservices.nutwork.de", "loginResponse");
    private final static QName _InvalidPasswordException_QNAME = new QName("webservices.nutwork.de", "InvalidPasswordException");
    private final static QName _NotFoundException_QNAME = new QName("webservices.nutwork.de", "NotFoundException");
    private final static QName _Login_QNAME = new QName("webservices.nutwork.de", "login");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.nutwork.webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link InvalidPasswordException }
     * 
     */
    public InvalidPasswordException createInvalidPasswordException() {
        return new InvalidPasswordException();
    }

    /**
     * Create an instance of {@link NotFoundException }
     * 
     */
    public NotFoundException createNotFoundException() {
        return new NotFoundException();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link SndtoUser }
     * 
     */
    public SndtoUser createSndtoUser() {
        return new SndtoUser();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "webservices.nutwork.de", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidPasswordException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "webservices.nutwork.de", name = "InvalidPasswordException")
    public JAXBElement<InvalidPasswordException> createInvalidPasswordException(InvalidPasswordException value) {
        return new JAXBElement<InvalidPasswordException>(_InvalidPasswordException_QNAME, InvalidPasswordException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "webservices.nutwork.de", name = "NotFoundException")
    public JAXBElement<NotFoundException> createNotFoundException(NotFoundException value) {
        return new JAXBElement<NotFoundException>(_NotFoundException_QNAME, NotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "webservices.nutwork.de", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

}
