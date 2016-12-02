package de.othr.sriethig.courseraproject.entity.base;

import de.othr.sriethig.courseraproject.entity.Course;
import de.othr.sriethig.courseraproject.entity.ExamResult;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author sonja
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractStudent extends AbstractUser {
    
    @ManyToMany(mappedBy="students", cascade = {CascadeType.PERSIST})
    @Getter @Setter private Collection<Course> courses;
    
    @OneToMany(mappedBy="student", cascade = {CascadeType.PERSIST})
    @Getter @Setter private Collection<ExamResult> results;
    
    /**
     * 
     * @param course 
     */
    public void addCourse(Course course) {
        this.courses.add(course);
    }
    
    /**
     * 
     * @param course 
     */
    public void removeCourse(Course course) {
        this.courses.remove(course);
    }
    
}
