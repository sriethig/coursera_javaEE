package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.Exam;
import de.othr.sriethig.courseraproject.entity.base.AbstractStudent;
import de.othr.sriethig.courseraproject.entity.base.SingleIdEntity_;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-18T11:30:59")
@StaticMetamodel(ExamResult.class)
public class ExamResult_ extends SingleIdEntity_ {

    public static volatile SingularAttribute<ExamResult, Exam> exam;
    public static volatile SingularAttribute<ExamResult, Integer> score;
    public static volatile SingularAttribute<ExamResult, AbstractStudent> student;
    public static volatile SingularAttribute<ExamResult, List> answers;

}