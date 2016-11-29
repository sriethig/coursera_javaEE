package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.Lesson;
import de.othr.sriethig.courseraproject.entity.Professor;
import de.othr.sriethig.courseraproject.entity.base.AbstractStudent;
import de.othr.sriethig.courseraproject.entity.base.SingleIdEntity_;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-29T16:18:45")
@StaticMetamodel(Course.class)
public class Course_ extends SingleIdEntity_ {

    public static volatile SingularAttribute<Course, Professor> professor;
    public static volatile SingularAttribute<Course, String> description;
    public static volatile CollectionAttribute<Course, AbstractStudent> students;
    public static volatile SingularAttribute<Course, String> title;
    public static volatile CollectionAttribute<Course, Lesson> lessons;

}