package com.MPGI.ECOMSport.EJBentity;

import javax.persistence.*;
import java.util.List;
/*import javax.persistence.TableGenerator;*/

@Entity
@Table(name = "adresse")
public class Adresse {

    /*@TableGenerator(name = "employee_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "employee_gen")
    */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAdresse;


    @Column(name = "active")
    private boolean active;

    @Column(name = "libelle")
    private String libelle;

    public int getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(int idAdresse) {
        this.idAdresse = idAdresse;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public int hashCode() {
        return idAdresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adresse adresse = (Adresse) o;

        return idAdresse == adresse.idAdresse;

    }
}

