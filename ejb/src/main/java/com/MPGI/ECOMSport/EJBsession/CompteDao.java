package com.MPGI.ECOMSport.EJBsession;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.MPGI.ECOMSport.EJBentity.Compte;

@Stateless
@LocalBean
public class CompteDao extends AbstractDao<Compte, Integer> implements InterfaceDao<Compte, Integer> {

    public CompteDao() {
        super(Compte.class);
    }

    public Compte findByLogin(String login) {
        Criteria criteria = getSession().createCriteria(Compte.class);
        return (Compte) criteria.add(Restrictions.eq("login", login))
                .uniqueResult();
    }
}
