/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.repository.base;

import java.util.List;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author sonja
 * @param <Long>
 * @param <AbstractUser>
 */
@Transactional
public abstract class AbstractUserRepository<Long, AbstractUser> extends 
        SingleIdEntityRepository {
    
    public AbstractUserRepository(Class type) {
        super(type);
    }
    
    /**
     * 
     * @param firstName
     * @return 
     */
    public List<AbstractUser> findByFirstName(String firstName) {
        TypedQuery query = this.getEntityManager().createQuery("SELECT u FROM "
                + "AbstractUser AS u WHERE u.firstName = :parametername", 
                this.getType()
        ); 
        query.setParameter("parametername", firstName);
        List<AbstractUser> abstractUsers = (List<AbstractUser>) query.getResultList();
        return abstractUsers;
    }
    
    /**
     * 
     * @param name
     * @return 
     */
    public List<AbstractUser> findByName(String name) {
        TypedQuery query = this.getEntityManager().createQuery("SELECT u FROM "
                + "AbstractUser AS u WHERE u.name = :parametername", 
                this.getType()
        ); 
        query.setParameter("parametername", name);
        List<AbstractUser> abstractUsers = (List<AbstractUser>) query.getResultList();
        return abstractUsers;
    }
    
    
}
