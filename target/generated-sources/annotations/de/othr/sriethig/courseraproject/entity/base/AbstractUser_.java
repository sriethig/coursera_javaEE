package de.othr.sriethig.courseraproject.entity.base;

import de.othr.sriethig.courseraproject.entity.Address;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-31T11:09:03")
@StaticMetamodel(AbstractUser.class)
public abstract class AbstractUser_ extends SingleIdEntity_ {

    public static volatile SingularAttribute<AbstractUser, String> firstName;
    public static volatile SingularAttribute<AbstractUser, String> emailAddress;
    public static volatile SingularAttribute<AbstractUser, String> password;
    public static volatile SingularAttribute<AbstractUser, Address> address;
    public static volatile SingularAttribute<AbstractUser, String> name;

}