/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.othr.sriethig.courseraproject.repository.base;

import de.othr.sriethig.courseraproject.entity.base.SingleIdEntity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author sonja
 * @param <K>
 * @param <E>
 */
public abstract class SingleIdEntityRepository<K, E extends SingleIdEntity> implements Serializable {
    
    @PersistenceContext(unitName="courseraPU")
    private EntityManager entityManager;
    
    private final Class<E> type;

    /**
     * 
     * @param type 
     */
    public SingleIdEntityRepository(Class<E> type) {
        this.type = type;
    }

    /**
     * 
     * @return 
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * 
     * @param entityManager 
     */
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * 
     * @return 
     */
    public Class<E> getType() {
        return type;
    }
    
    /**
     * 
     * @param entity 
     */
    public void persist(E entity) {
        this.entityManager.persist(entity);
    }
    
    /**
     * 
     * @param entities 
     */
    public void persist(List<E> entities) {
        for(E entity : entities) {
            this.getEntityManager().persist(entity);
        }
    }
    
    /**
     * 
     * @param entity
     * @return 
     */
    public E merge(E entity) {
        return this.entityManager.merge(entity);
    }
    
    /**
     * 
     * @param entity 
     */
    public void remove(E entity) {
        entity = this.getEntityManager().merge(entity);
        this.entityManager.remove(entity);
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public E findById(K id) {
        return this.entityManager.find(type, id);
    }
    
    /**
     * 
     * @return 
     */
    public List<E> findAll() {
        CriteriaBuilder criteriaBuilder = 
                this.entityManager.getCriteriaBuilder();
        CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(type);
        Root<E> rootEntry = criteriaQuery.from(type);
        CriteriaQuery<E> all = criteriaQuery.select(rootEntry);
        TypedQuery<E> allQuery = this.entityManager.createQuery(all);

        return (List<E>) allQuery.getResultList();
    }
}
