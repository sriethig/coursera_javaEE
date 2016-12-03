package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.Lesson;
import de.othr.sriethig.courseraproject.entity.base.SingleIdEntity_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-03T09:14:10")
@StaticMetamodel(LessonContent.class)
public class LessonContent_ extends SingleIdEntity_ {

    public static volatile SingularAttribute<LessonContent, Lesson> lesson;
    public static volatile SingularAttribute<LessonContent, String> text;
    public static volatile SingularAttribute<LessonContent, String> title;

}