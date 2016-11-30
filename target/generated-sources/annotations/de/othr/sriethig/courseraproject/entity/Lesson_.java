package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.Course;
import de.othr.sriethig.courseraproject.entity.Exam;
import de.othr.sriethig.courseraproject.entity.VideoWithText;
import de.othr.sriethig.courseraproject.entity.base.SingleIdEntity_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-30T22:01:50")
@StaticMetamodel(Lesson.class)
public class Lesson_ extends SingleIdEntity_ {

    public static volatile SingularAttribute<Lesson, Exam> exam;
    public static volatile SingularAttribute<Lesson, Course> course;
    public static volatile SingularAttribute<Lesson, VideoWithText> videoWithText;
    public static volatile SingularAttribute<Lesson, String> title;

}