package com.MPGI.ECOMSport.EJBentity;




import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/*import javax.persistence.TableGenerator;*/



@Entity
@Table(name = "theme")
public class Theme {

    /*@TableGenerator(name = "employee_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "employee_gen")
    */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTheme;

    @Column(name = "Nom")
    private String nom;

    @OneToMany(mappedBy = "theme")
    private List<Categorie> categories;

    public Theme() {
        this.categories = new ArrayList<Categorie>();
    }

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void addCategorie(Categorie categorie) {
        if (categories.contains(categorie)) {
            return;
        }
        categories.add(categorie);
    }

    public void removeCategorie(Categorie categorie) {
        if (!categories.contains(categorie)) {
            return;
        }
        categories.remove(categorie);
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }

    @Override
    public int hashCode() {
        return idTheme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Theme theme = (Theme) o;

        return idTheme == theme.idTheme;

    }
}
