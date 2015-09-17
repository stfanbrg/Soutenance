package com.MPGI.ECOMSport.EJBsession;

import javax.ejb.Local;
import java.io.Serializable;
import java.util.List;

public interface InterfaceDao<T, PK extends Serializable> {

    List<T> findAll();

    T findById(PK id);

    PK save(T object);

    void remove(T object);

    void update(T object);


}