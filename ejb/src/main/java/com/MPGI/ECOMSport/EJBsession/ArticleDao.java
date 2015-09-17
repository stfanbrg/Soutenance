package com.MPGI.ECOMSport.EJBsession;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.MPGI.ECOMSport.EJBentity.Article;
import com.MPGI.ECOMSport.EJBentity.Categorie;
import com.MPGI.ECOMSport.EJBentity.Theme;

	

@Stateless
@LocalBean
public class ArticleDao extends AbstractDao<Article, Integer> implements InterfaceDao<Article, Integer> {


    public ArticleDao() {
        super(Article.class);
    }

    public List<Article> findByLikeName(String name) {
        if (name.equals(""))
            return findAll();
        return em.createQuery("SELECT object(a) FROM Article a 	INNER JOIN a.categorie c INNER JOIN c.theme t WHERE a.nom LIKE :articleName or c.nom LIKE :articleName2 or t.nom LIKE :articleName3", Article.class)
                .setParameter("articleName","%" + name + "%")
                .setParameter("articleName2",name + "%")
                .setParameter("articleName3",name + "%")
                .getResultList();
    }

    public List<Article> findSelection(Theme theme) {
    	return em.createQuery("SELECT object(a) FROM Article as a INNER JOIN a.categorie as  c INNER JOIN c.theme as t WHERE t.nom =:themeName", Article.class)
                .setParameter("themeName", theme.getNom())
                .getResultList();
    }
    
    public List<Article> findSelectionCategorie(Theme theme, Categorie categorie) {
    	return em.createQuery("SELECT object(a) FROM Article as a INNER JOIN a.categorie as  c INNER JOIN c.theme as t WHERE c.nom =:categorieName and t.nom =:themeName", Article.class)
    			.setParameter("categorieName", categorie.getNom())
    			.setParameter("themeName", theme.getNom())
                .getResultList();
    }
}

