
package services.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for paperBook complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="paperBook">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Impl.Services/}abstractBook">
 *       &lt;sequence>
 *         &lt;element name="copies" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "paperBook", propOrder = {
    "copies"
})
public class PaperBook
    extends AbstractBook
{

    protected int copies;

    /**
     * Gets the value of the copies property.
     * 
     */
    public int getCopies() {
        return copies;
    }

    /**
     * Sets the value of the copies property.
     * 
     */
    public void setCopies(int value) {
        this.copies = value;
    }

}
