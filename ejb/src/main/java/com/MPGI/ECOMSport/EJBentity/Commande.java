package com.MPGI.ECOMSport.EJBentity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
/*import javax.persistence.TableGenerator;*/

@Entity
@Table(name = "commande")
public class Commande {

    /*@TableGenerator(name = "employee_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "employee_gen")
    */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCommande;

    @ManyToOne
    @JoinColumn(name = "id_adresse")
    private Adresse adresse;

    @Column(name = "Prix")
    private int prix;

    @Column(name = "Date")
    private Date date;

    @Column(name = "Statut")
    private String statut;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "commande_article",
            joinColumns = @JoinColumn(name = "id_commande"),
            inverseJoinColumns = @JoinColumn(name = "id_article"))
    private List<Article> articles;

    public Commande() {
        this.articles = new ArrayList<Article>();
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void addArticle(Article article) {
        if (articles.contains(article)) {
            return;
        }
        this.articles.add(article);
    }

    public void removeArticle(Article article) {
        if (!articles.contains(article)) {
            return;
        }
        this.articles.remove(article);
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public int hashCode() {
        return idCommande;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commande commande = (Commande) o;

        return idCommande == commande.idCommande;

    }
}
