package com.MPGI.ECOMSport.EJBsession;


import com.MPGI.ECOMSport.EJBentity.Adresse;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class AdresseDao extends AbstractDao<Adresse, Integer> implements InterfaceDao<Adresse, Integer> {


    public AdresseDao() {
        super(Adresse.class);
    }
}
