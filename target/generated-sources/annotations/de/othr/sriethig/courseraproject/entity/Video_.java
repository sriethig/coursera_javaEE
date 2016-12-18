package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.Lesson;
import de.othr.sriethig.courseraproject.entity.base.SingleIdEntity_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-18T11:30:59")
@StaticMetamodel(Video.class)
public class Video_ extends SingleIdEntity_ {

    public static volatile SingularAttribute<Video, Lesson> lesson;
    public static volatile SingularAttribute<Video, String> description;
    public static volatile SingularAttribute<Video, String> title;
    public static volatile SingularAttribute<Video, String> url;

}