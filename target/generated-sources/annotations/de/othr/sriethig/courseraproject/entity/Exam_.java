package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.ExamResult;
import de.othr.sriethig.courseraproject.entity.Lesson;
import de.othr.sriethig.courseraproject.entity.base.SingleIdEntity_;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-18T11:30:59")
@StaticMetamodel(Exam.class)
public class Exam_ extends SingleIdEntity_ {

    public static volatile SingularAttribute<Exam, List> questions;
    public static volatile SingularAttribute<Exam, Lesson> lesson;
    public static volatile SingularAttribute<Exam, String> title;
    public static volatile CollectionAttribute<Exam, ExamResult> results;

}