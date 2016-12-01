/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.repository.base;

import de.othr.sriethig.courseraproject.entity.base.AbstractUser;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import javax.transaction.TransactionalException;

/**
 *
 * @author sonja
 */
@SessionScoped
public class AbstractUserRepository extends 
        SingleIdEntityRepository<Long, AbstractUser> implements Serializable {
    
    public AbstractUserRepository() {
        super(AbstractUser.class);
    }
    
    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    public AbstractUser authenticateAbstractUser(String email, String password) {
        TypedQuery<AbstractUser> query = this.createTypedQuery(
            "SELECT u FROM AbstractUser u WHERE u.emailAddress = "
                    + ":parameter1 AND u.password = :parameter2"
        );
        query.setParameter("parameter1", email);
        query.setParameter("parameter2", password);
        List<AbstractUser> abstractUsers = query.getResultList();
        if(abstractUsers.isEmpty()) {
            return null;
        } else {
            AbstractUser abstractUser = abstractUsers.get(0);
            return abstractUser;
        }      
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
