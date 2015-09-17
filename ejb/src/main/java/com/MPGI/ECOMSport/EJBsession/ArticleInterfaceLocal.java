package com.MPGI.ECOMSport.EJBsession;

import java.util.List;

import javax.ejb.Local;

import com.MPGI.ECOMSport.EJBentity.Article;
import com.MPGI.ECOMSport.EJBentity.Theme;
import com.MPGI.ECOMSport.EJBentity.Categorie;

@Local
public interface ArticleInterfaceLocal {
	void  add(Article newArticle);
	void edit(Article newArticle);
	Article find(Object id);
	List<Article> findAllArticles();
}
