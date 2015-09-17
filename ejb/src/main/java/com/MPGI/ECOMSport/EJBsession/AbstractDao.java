package com.MPGI.ECOMSport.EJBsession;

import org.hibernate.Criteria;
import org.hibernate.Session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractDao<T, PK extends Serializable> implements InterfaceDao<T, PK> {

    @PersistenceContext(unitName = "primary")
    protected EntityManager em;
    /*
    this exist cause you can't pass T in this.session.get has class name
     */
    private Class<T> clazz;

    public AbstractDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public List<T> findAll() {
        Criteria criteria = getSession().createCriteria(clazz);
        return (List<T>) criteria.list();
    }

    @Override
    public T findById(PK id) {
        return (T) getSession().get(clazz, id);
    }

    @Override
    public PK save(T object) {
        return (PK) getSession().save(object);
    }

    @Override
    public void remove(T object) {
        getSession().delete(object);
    }

    @Override
    public void update(T object) {
        getSession().update(object);
    }

    protected Session getSession() {
        return (Session) this.em.getDelegate();
    }
}
