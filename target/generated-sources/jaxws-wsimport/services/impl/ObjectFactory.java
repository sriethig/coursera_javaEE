
package services.impl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the services.impl package. 
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

    private final static QName _FindAll_QNAME = new QName("http://Impl.Services/", "findAll");
    private final static QName _AbstractBook_QNAME = new QName("http://Impl.Services/", "abstractBook");
    private final static QName _FindAllResponse_QNAME = new QName("http://Impl.Services/", "findAllResponse");
    private final static QName _Author_QNAME = new QName("http://Impl.Services/", "author");
    private final static QName _SearchBooksResponse_QNAME = new QName("http://Impl.Services/", "searchBooksResponse");
    private final static QName _SearchBooks_QNAME = new QName("http://Impl.Services/", "searchBooks");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: services.impl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SearchBooks }
     * 
     */
    public SearchBooks createSearchBooks() {
        return new SearchBooks();
    }

    /**
     * Create an instance of {@link SearchBooksResponse }
     * 
     */
    public SearchBooksResponse createSearchBooksResponse() {
        return new SearchBooksResponse();
    }

    /**
     * Create an instance of {@link Author }
     * 
     */
    public Author createAuthor() {
        return new Author();
    }

    /**
     * Create an instance of {@link FindAllResponse }
     * 
     */
    public FindAllResponse createFindAllResponse() {
        return new FindAllResponse();
    }

    /**
     * Create an instance of {@link FindAll }
     * 
     */
    public FindAll createFindAll() {
        return new FindAll();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link PaperBook }
     * 
     */
    public PaperBook createPaperBook() {
        return new PaperBook();
    }

    /**
     * Create an instance of {@link RandomIdEntity }
     * 
     */
    public RandomIdEntity createRandomIdEntity() {
        return new RandomIdEntity();
    }

    /**
     * Create an instance of {@link ElectronicBook }
     * 
     */
    public ElectronicBook createElectronicBook() {
        return new ElectronicBook();
    }

    /**
     * Create an instance of {@link GeneratedIdEntity }
     * 
     */
    public GeneratedIdEntity createGeneratedIdEntity() {
        return new GeneratedIdEntity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Impl.Services/", name = "findAll")
    public JAXBElement<FindAll> createFindAll(FindAll value) {
        return new JAXBElement<FindAll>(_FindAll_QNAME, FindAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Impl.Services/", name = "abstractBook")
    public JAXBElement<AbstractBook> createAbstractBook(AbstractBook value) {
        return new JAXBElement<AbstractBook>(_AbstractBook_QNAME, AbstractBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Impl.Services/", name = "findAllResponse")
    public JAXBElement<FindAllResponse> createFindAllResponse(FindAllResponse value) {
        return new JAXBElement<FindAllResponse>(_FindAllResponse_QNAME, FindAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Author }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Impl.Services/", name = "author")
    public JAXBElement<Author> createAuthor(Author value) {
        return new JAXBElement<Author>(_Author_QNAME, Author.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchBooksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Impl.Services/", name = "searchBooksResponse")
    public JAXBElement<SearchBooksResponse> createSearchBooksResponse(SearchBooksResponse value) {
        return new JAXBElement<SearchBooksResponse>(_SearchBooksResponse_QNAME, SearchBooksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchBooks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Impl.Services/", name = "searchBooks")
    public JAXBElement<SearchBooks> createSearchBooks(SearchBooks value) {
        return new JAXBElement<SearchBooks>(_SearchBooks_QNAME, SearchBooks.class, null, value);
    }

}
