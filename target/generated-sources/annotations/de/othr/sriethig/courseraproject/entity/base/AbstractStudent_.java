package de.othr.sriethig.courseraproject.entity.base;

import de.othr.sriethig.courseraproject.entity.Course;
import de.othr.sriethig.courseraproject.entity.ExamResult;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-30T22:37:21")
@StaticMetamodel(AbstractStudent.class)
public abstract class AbstractStudent_ extends AbstractUser_ {

    public static volatile CollectionAttribute<AbstractStudent, Course> courses;
    public static volatile CollectionAttribute<AbstractStudent, ExamResult> results;

}