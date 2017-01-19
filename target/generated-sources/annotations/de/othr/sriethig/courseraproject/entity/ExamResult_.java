package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.Exam;
import de.othr.sriethig.courseraproject.entity.base.AbstractStudent;
import de.othr.sriethig.courseraproject.entity.base.SingleIdEntity_;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-19T22:06:25")
@StaticMetamodel(ExamResult.class)
public class ExamResult_ extends SingleIdEntity_ {

    public static volatile SingularAttribute<ExamResult, Exam> exam;
    public static volatile SingularAttribute<ExamResult, Integer> score;
    public static volatile SingularAttribute<ExamResult, AbstractStudent> student;
    public static volatile ListAttribute<ExamResult, String> answers;

}