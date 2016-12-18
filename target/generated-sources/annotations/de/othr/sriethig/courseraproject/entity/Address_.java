package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.Country;
import de.othr.sriethig.courseraproject.entity.base.SingleIdEntity_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< Updated upstream
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-01T18:32:01")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-18T00:01:54")
>>>>>>> Stashed changes
@StaticMetamodel(Address.class)
public class Address_ extends SingleIdEntity_ {

    public static volatile SingularAttribute<Address, Long> zipCode;
    public static volatile SingularAttribute<Address, Country> country;
    public static volatile SingularAttribute<Address, String> city;
    public static volatile SingularAttribute<Address, String> street;

}