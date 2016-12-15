package de.othr.sriethig.courseraproject.entity.base;

import de.othr.sriethig.courseraproject.entity.Course;
import de.othr.sriethig.courseraproject.entity.ExamResult;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    
    @ManyToMany(mappedBy="students", cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @Getter @Setter private Collection<Course> courses;
    
    @OneToMany(mappedBy="student", cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @Getter @Setter private Collection<ExamResult> results;
    
    /**
     * 
     * @param course 
     * @return  
     */
    public AbstractStudent addCourse(Course course) {
        if(!this.courses.contains(course)) {
            this.courses.add(course);
        }
        return this;
    }
    
    /**
     * 
     * @param course 
     * @return  
     */
    public AbstractStudent removeCourse(Course course) {
        if(this.courses.contains(course)) {
            this.courses.remove(course);
        }
        return this;
    }
    
}
