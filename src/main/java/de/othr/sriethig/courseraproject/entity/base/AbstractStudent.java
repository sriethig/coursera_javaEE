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

/**
 * 
 * @author sonja
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractStudent extends AbstractUser {
    
    @ManyToMany(mappedBy="students", cascade = {CascadeType.PERSIST})
    private Collection<Course> courses;
    
    @OneToMany(mappedBy="student", cascade = {CascadeType.PERSIST})
    private Collection<ExamResult> results;
    
    /**
     * 
     */
    public AbstractStudent() {
    }

    /**
     * 
     * @return 
     */
    public Collection<Course> getCourses() {
        return courses;
    }

    /**
     * 
     * @param courses 
     */
    public void setCourses(Collection<Course> courses) {
        this.courses = courses;
    }

    /**
     * 
     * @return 
     */
    public Collection<ExamResult> getResults() {
        return results;
    }

    /**
     * 
     * @param results 
     */
    public void setResults(Collection<ExamResult> results) {
        this.results = results;
    }
    
}
