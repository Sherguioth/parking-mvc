package com.sherguioth.parking.utils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class JpaRepository<T> implements GenericRepository<T> {

    protected EntityManager entityManager;
    private final Class<T> type;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public JpaRepository() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) t;
        type = (Class) parameterizedType.getActualTypeArguments()[0];
    }

    @Override
    public T create(final T t) {
        entityManager.persist(t);
        return t;
    }

    @Override
    public void delete(final Object objet) {
        entityManager.remove(entityManager.merge(objet));
    }

    @Override
    public T find(final Object id) {
        return entityManager.find(type, id);
    }

    @Override
    public T update(final T t) {
        return entityManager.merge(t);
    }

    @Override
    public Iterable<T> findAll() {
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = cb.createQuery(type);
        Root<T> root = criteriaQuery.from(type);
        criteriaQuery.select(root);
        TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
