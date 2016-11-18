package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.Lesson;
import de.othr.sriethig.courseraproject.entity.base.SingleIdEntity_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-18T18:11:45")
@StaticMetamodel(VideoWithText.class)
public class VideoWithText_ extends SingleIdEntity_ {

    public static volatile SingularAttribute<VideoWithText, String> videoDescription;
    public static volatile SingularAttribute<VideoWithText, String> videoURL;
    public static volatile SingularAttribute<VideoWithText, Lesson> lesson;
    public static volatile SingularAttribute<VideoWithText, String> videoTitle;

}