package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.Address;
import de.othr.sriethig.courseraproject.entity.Course;
import de.othr.sriethig.courseraproject.entity.base.SingleIdEntity_;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-18T18:11:45")
@StaticMetamodel(Professor.class)
public class Professor_ extends SingleIdEntity_ {

    public static volatile SingularAttribute<Professor, String> firstName;
    public static volatile CollectionAttribute<Professor, Course> courses;
    public static volatile SingularAttribute<Professor, Address> address;
    public static volatile SingularAttribute<Professor, String> name;

}