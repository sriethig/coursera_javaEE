    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.entity.base;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sonja
 */
@MappedSuperclass
abstract public class SingleIdEntity<T> implements Serializable {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private T Id;

    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        return (Id != null)? Id.hashCode() : 0;
    }

    /**
     * 
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SingleIdEntity<?> other = (SingleIdEntity<?>) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "SingleIdEntity{" + "Id=" + Id + '}';
    }
}
