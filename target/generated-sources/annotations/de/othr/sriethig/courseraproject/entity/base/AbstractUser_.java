package de.othr.sriethig.courseraproject.entity.base;

import de.othr.sriethig.courseraproject.entity.Address;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< Updated upstream
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-01T18:32:01")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-18T00:01:54")
>>>>>>> Stashed changes
@StaticMetamodel(AbstractUser.class)
public abstract class AbstractUser_ extends SingleIdEntity_ {

    public static volatile SingularAttribute<AbstractUser, String> firstName;
    public static volatile SingularAttribute<AbstractUser, String> emailAddress;
    public static volatile SingularAttribute<AbstractUser, String> password;
    public static volatile SingularAttribute<AbstractUser, Address> address;
    public static volatile SingularAttribute<AbstractUser, String> name;

}