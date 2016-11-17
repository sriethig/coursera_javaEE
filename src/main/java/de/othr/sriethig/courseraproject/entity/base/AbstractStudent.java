package de.othr.sriethig.courseraproject.entity.base;

import de.othr.sriethig.courseraproject.entity.Address;
import de.othr.sriethig.courseraproject.entity.Course;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 * 
 * @author sonja
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class AbstractStudent extends SingleIdEntity {
    
    private String name;
    private String firstName;
    
    @OneToOne(cascade = {CascadeType.PERSIST})
    private Address address;
    
    @ManyToMany(mappedBy="students", cascade = {CascadeType.PERSIST})
    private Collection<Course> courses;
    
    /**
     * 
     */
    public AbstractStudent() {
        this.courses = new ArrayList<>();
    }

    /**
     * 
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return 
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @param firstName 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 
     * @return 
     */
    public Address getAddress() {
        return address;
    }

    /**
     * 
     * @param address 
     */
    public void setAddress(Address address) {
        this.address = address;
    }
}
