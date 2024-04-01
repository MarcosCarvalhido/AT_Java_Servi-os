package com.sparkweb.sparkweb.dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class GenericDAO <E> {
    private static EntityManagerFactory emf;
    private EntityManager em;

    private Class<E> type;

    static {
        try{
            emf = Persistence.createEntityManagerFactory("spark-java-hibernate");
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public GenericDAO(Class<E> type) {
        this.type = type;
        em = emf.createEntityManager();

    }
    public GenericDAO<E> begin(){
        em.getTransaction().begin();
        return this;
    }
    public GenericDAO<E> end(){
        em.getTransaction().commit();
        return this;
    }
    public void create(E entity){
        em.persist(entity);
    }
    public void update(E entity){
        em.merge(entity);
    }
    public GenericDAO<E> delete (long id){
        GenericDAO<E> dao = new GenericDAO<E>(type);
        E entity = dao.findById(id);
        em.remove( em.contains(entity) ? entity : em.merge(entity));
        return this;
    }

    public E findById(Object id) {
        return em.find(type,id);
    }
    public List<E> findAll(){
        Query query = em.createQuery("FROM "+ type.getSimpleName());
        return query.getResultList();
    }

}
