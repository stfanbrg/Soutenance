package com.MPGI.ECOMSport.MgrBean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.MPGI.ECOMSport.EJBentity.Article;
import com.MPGI.ECOMSport.EJBsession.ArticleDao;
import com.MPGI.ECOMSport.beans.PanierSession;
import com.MPGI.ECOMSport.beans.SelectedArticle;


@ManagedBean(name = "articleController")
@RequestScoped
public class ArticleController {

	private int idSelectedArticle;

	public int getIdSelectedArticle() {
		return idSelectedArticle;
	}
	public void setIdSelectedArticle(int idSelectedArticle) {
		this.idSelectedArticle = idSelectedArticle;
	}
	public ArticleDao getArticleDao() {
		return articleDao;
	}
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	public static PanierSession getCurrentPanierSession() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		return (PanierSession) facesContext.getExternalContext().getSessionMap().get("panierSession");


	}
	public static SelectedArticle getCurrentSelectedArticle() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		return (SelectedArticle) facesContext.getExternalContext().getSessionMap().get("selectedArticle");
	}

	@EJB
	private ArticleDao articleDao;
	public String recherche;

	@PostConstruct
	public void init() {

	}

	public String getRecherche() {
		return recherche;
	}

	public void setRecherche(String recherche) {
		this.recherche = recherche;
	}

	public List<Article> getAllArticles() {
		return articleDao.findAll();
	}

	public List<Article> getArticlesSearch() {
		if (recherche!=null)
			return articleDao.findByLikeName(this.recherche);
		if (CompteController.getCurrentCompte()!=null){
			this.recherche=null;
			if (CompteController.getCurrentCompte().getCategorie()!=null)
				return articleDao.findSelectionCategorie(CompteController.getCurrentCompte().getTheme(),CompteController.getCurrentCompte().getCategorie());
			else if(CompteController.getCurrentCompte().getTheme()!=null)
				return articleDao.findSelection(CompteController.getCurrentCompte().getTheme());
		}
		return articleDao.findAll();
	}

	public void saveArticle(Article newArticle) {
		articleDao.save(newArticle);
	}

	public Article readArticle(int idArticle) {
		return articleDao.findById(idArticle);
	}


	public List<Article> getPanierArticles() {
		return getCurrentPanierSession().getArticles();
	}

	public String selectArticle()
	{		
		Article article1 = readArticle(getCurrentSelectedArticle().getIdArticle());
		if(article1==null)
			return "index";
		getCurrentPanierSession().addArticle(article1);
		return "Panier";
	}
}
