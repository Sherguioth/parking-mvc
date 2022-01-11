package com.sherguioth.parking.utils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JpaRepository<T, ID> implements GenericRepository<T, ID> {

    protected EntityManager entityManager;
    private final Class<T> entityClass;

    public JpaRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public T find(final ID id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public T save(final T t) {
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
        return t;
    }

    @Override
    public T update(T t) {
        entityManager.getTransaction().begin();
        t = entityManager.merge(t);
        entityManager.getTransaction().commit();
        return t;

    }

    @Override
    public void delete(final Object objet) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(objet));
        entityManager.getTransaction().commit();
    }

    @Override
    public List<T> findAll() {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = cb.createQuery(entityClass);
        Root<T> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(root);
        TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
