/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asseco.trening.DAO;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


public abstract class AbstractDAO<T> {

    @PersistenceContext(unitName = "trening")
    private EntityManager em;

    public final Class<T> entityClass;

    protected EntityManager getEntityManager() {
        return em;
    }

    public AbstractDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    //samo logira
    public void create(T entity) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(entity);
        if (constraintViolations.size() > 0) {
            Iterator<ConstraintViolation<T>> iterator = constraintViolations.iterator();
            while (iterator.hasNext()) {
                ConstraintViolation<T> cv = iterator.next();
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, "{0}.{1} {2}", new Object[]{cv.getRootBeanClass().getName(), cv.getPropertyPath(), cv.getMessage()});
            }
        } else {
            getEntityManager().persist(entity);
        }
    }

    public T edit(T entity) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(entity);
        if (constraintViolations.size() > 0) {
            Iterator<ConstraintViolation<T>> iterator = constraintViolations.iterator();
            while (iterator.hasNext()) {
                ConstraintViolation<T> cv = iterator.next();
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, "{0}.{1} {2}", new Object[]{cv.getRootBeanClass().getName(), cv.getPropertyPath(), cv.getMessage()});
            }
            return null;
        } else {
            try {
                return getEntityManager().merge(entity);
            }
            catch (OptimisticLockException ole)
            {
                throw new OptimisticLockException(ole);
            }

        }

    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }


    public T find(Object id) {
        return (T) getEntityManager().find(entityClass, id);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public T findNewT(Object id) {
        return (T) getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        Query q = getEntityManager().createQuery("from " + getEntityClass().getSimpleName() + " clen");
        return q.getResultList();

    }


    public Boolean isManaged(Object object){
        return getEntityManager().contains(object);
    }

    public void flush() {
        getEntityManager().flush();
    }

    public void refresh(T t) {
        getEntityManager().refresh(t);
    }

    public List<T> findDuplicates() {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root root = cq.from(entityClass);
        cq.select(root);
        return getEntityManager().createQuery(cq).getResultList();
    }

    public T getSingleResultOrNull(CriteriaQuery cq) {
        List results = getEntityManager().createQuery(cq).getResultList();
        if (results.isEmpty()) {
            return null;
        } else if (results.size() == 1) {
            return (T) results.get(0);
        }
        throw new NonUniqueResultException();
    }

    //@TransactionAttribute(TransactionAttributeType.MANDATORY)
    public T merge(T entity) {
        return getEntityManager().merge(entity);
    }

    //@TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void persist(T entity) {
        getEntityManager().persist(entity);
    }

    public T customFind(Class classin, String entityId){
        return (T)getEntityManager().find(classin,entityId);
    }

    public void detach (T entity){
        getEntityManager().detach(entity);
    }

    protected Class<T> getEntityClass() {
        return entityClass;
    }
}