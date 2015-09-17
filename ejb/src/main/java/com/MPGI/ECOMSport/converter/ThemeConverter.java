package com.MPGI.ECOMSport.converter;


import com.MPGI.ECOMSport.EJBentity.Theme;
import com.MPGI.ECOMSport.EJBsession.ThemeDao;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@ManagedBean(name = "themeConverter")
@RequestScoped
public class ThemeConverter implements Converter {
    @EJB
    private ThemeDao themeDao;


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        return themeDao.findById(Integer.valueOf(s));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        Integer id = ((Theme) o).getIdTheme();
        return id.toString();
    }
}
