package de.othr.sriethig.courseraproject.entity.base;

import de.othr.sriethig.courseraproject.entity.Address;
import de.othr.sriethig.courseraproject.entity.Course;
import de.othr.sriethig.courseraproject.entity.ExamResult;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-18T18:11:45")
@StaticMetamodel(AbstractStudent.class)
public class AbstractStudent_ extends SingleIdEntity_ {

    public static volatile SingularAttribute<AbstractStudent, String> firstName;
    public static volatile CollectionAttribute<AbstractStudent, Course> courses;
    public static volatile SingularAttribute<AbstractStudent, Address> address;
    public static volatile SingularAttribute<AbstractStudent, String> name;
    public static volatile CollectionAttribute<AbstractStudent, ExamResult> results;

}