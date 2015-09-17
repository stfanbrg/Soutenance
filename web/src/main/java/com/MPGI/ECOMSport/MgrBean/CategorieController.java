package com.MPGI.ECOMSport.MgrBean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.MPGI.ECOMSport.EJBentity.Categorie;
import com.MPGI.ECOMSport.EJBsession.CategorieDao;


@ManagedBean(name = "categorieController")
@RequestScoped
public class CategorieController {


    @EJB
    private CategorieDao categorieDao;

    @PostConstruct
    public void init() {
    	Categorie categorie = new Categorie();
    }

    public List<Categorie> getAllCategories() {
        return categorieDao.findAll();
    }

    public void saveCategorie(Categorie newCategorie) {
        System.out.println(categorieDao);
        categorieDao.save(newCategorie);
    }

    public Categorie readTCategorie(int idCategorie) {
        return categorieDao.findById(idCategorie);
    }
    
    public List<Categorie> getCategoriesByTheme(){
    	if(CompteController.getCurrentCompte().getTheme()!=null)
    		return categorieDao.findCategorieByTheme(CompteController.getCurrentCompte().getTheme());
    	return null;
    }
}
