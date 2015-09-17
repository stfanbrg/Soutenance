package com.MPGI.ECOMSport.EJBsession;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.MPGI.ECOMSport.EJBentity.Theme;


@Stateless
@LocalBean
public class ThemeDao extends AbstractDao<Theme, Integer> implements InterfaceDao<Theme, Integer> {


    public ThemeDao() {
        super(Theme.class);
    }
}
