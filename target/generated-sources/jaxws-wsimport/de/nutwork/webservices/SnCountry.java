
package de.nutwork.webservices;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for snCountry.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="snCountry">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="GERMANY"/>
 *     &lt;enumeration value="USA"/>
 *     &lt;enumeration value="FRANCE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "snCountry")
@XmlEnum
public enum SnCountry {

    GERMANY,
    USA,
    FRANCE;

    public String value() {
        return name();
    }

    public static SnCountry fromValue(String v) {
        return valueOf(v);
    }

}
