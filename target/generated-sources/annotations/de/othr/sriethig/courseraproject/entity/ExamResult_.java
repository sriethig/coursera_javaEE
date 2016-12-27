package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.Exam;
import de.othr.sriethig.courseraproject.entity.base.AbstractStudent;
import de.othr.sriethig.courseraproject.entity.base.SingleIdEntity_;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-27T18:36:30")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-17T18:46:31")
>>>>>>> master
@StaticMetamodel(ExamResult.class)
public class ExamResult_ extends SingleIdEntity_ {

    public static volatile SingularAttribute<ExamResult, Exam> exam;
    public static volatile SingularAttribute<ExamResult, Integer> score;
    public static volatile SingularAttribute<ExamResult, AbstractStudent> student;
    public static volatile SingularAttribute<ExamResult, List> answers;

}