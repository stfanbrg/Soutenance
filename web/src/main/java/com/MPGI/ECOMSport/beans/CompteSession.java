package com.MPGI.ECOMSport.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.MPGI.ECOMSport.EJBentity.Categorie;
import com.MPGI.ECOMSport.EJBentity.Compte;
import com.MPGI.ECOMSport.EJBentity.Theme;



@ManagedBean(name = "compteSession")
@SessionScoped
public class CompteSession extends Compte {
    private Theme theme;
    private Categorie categorie;

    public Theme getTheme() {
        return theme;
    }

    public String setTheme(Theme theme) {
    	this.categorie=null;
    	this.theme = theme;
    	return "index";
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public String setCategorie(Categorie categorie) {
        this.categorie = categorie;
        return "index";
    }

    public String removeCategorie() {
        this.categorie = null;
        return "index";
    }
}
