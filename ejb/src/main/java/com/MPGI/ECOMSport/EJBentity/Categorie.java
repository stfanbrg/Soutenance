package com.MPGI.ECOMSport.EJBentity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/*import javax.persistence.TableGenerator;*/

@Entity
@Table(name = "categorie")
public class Categorie {

    /*@TableGenerator(name = "employee_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "employee_gen")
    */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCategorie;

    @ManyToOne
    @JoinColumn(name = "id_theme")
    private Theme theme;

    @OneToMany(mappedBy = "categorie")
    private List<Article> articles;

    @Column(name = "Nom")
    private String nom;

    public Categorie() {
        articles = new ArrayList<Article>();
    }

    public void addArticle(Article article) {
        if (articles.contains(article)) {
            return;
        }
        articles.add(article);
    }

    public void removeArticle(Article article) {
        if (!articles.contains(article)) {
            return;
        }
        articles.remove(article);
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
        theme.addCategorie(this);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int hashCode() {
        return idCategorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categorie categorie = (Categorie) o;

        return idCategorie == categorie.idCategorie;

    }
}
