package de.othr.sriethig.courseraproject.entity;

import de.othr.sriethig.courseraproject.entity.Course;
import de.othr.sriethig.courseraproject.entity.base.AbstractUser_;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-18T14:00:30")
@StaticMetamodel(Professor.class)
public class Professor_ extends AbstractUser_ {

    public static volatile CollectionAttribute<Professor, Course> courses;

}