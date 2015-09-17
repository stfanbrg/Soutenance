package com.MPGI.ECOMSport.EJBentity;

import javax.persistence.*;
/*import javax.persistence.TableGenerator;*/

@Entity
@Table(name = "article")
public class Article {

    /*@TableGenerator(name = "employee_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "employee_gen")
    */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idArticle;

    @ManyToOne
    @JoinColumn(name = "id_categorie")
    private Categorie categorie;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Marque")
    private String marque;

    @Column(name = "Prix")
    private int prix;

    @Column(name = "Stock")
    private int stock;
    
    @Column(name = "Image")
    private String image;

    public String getImage() {
		return image;
	}

	public void setImage(String Image) {
		this.image = Image;
	}

	public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
        categorie.addArticle(this);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        return idArticle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        return idArticle == article.idArticle;

    }
}