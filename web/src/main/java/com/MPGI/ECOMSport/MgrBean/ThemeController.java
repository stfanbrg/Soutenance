package com.MPGI.ECOMSport.MgrBean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.MPGI.ECOMSport.EJBentity.Article;
import com.MPGI.ECOMSport.EJBentity.Theme;
import com.MPGI.ECOMSport.EJBsession.ThemeDao;
import com.MPGI.ECOMSport.beans.CompteSession;


@ManagedBean(name = "themeController")
@RequestScoped
public class ThemeController {


    @EJB
    private ThemeDao themeDao;

    @PostConstruct
    public void init() {
    	/*Theme theme = new Theme();
    	theme.setIdTheme(1);
    	theme.setNom("ski");
    	saveTheme(theme);
    	Theme theme1 = new Theme();
    	theme1.setIdTheme(2);
    	theme1.setNom("snowboard");
    	saveTheme(theme1);*/
    	
    }

    public List<Theme> getAllThemes() {

        return themeDao.findAll();
    }

    public void saveTheme(Theme newTheme) {
        System.out.println(themeDao);
        themeDao.save(newTheme);
    }

    public Theme readTheme(int idTheme) {
        return themeDao.findById(idTheme);
    }
}
