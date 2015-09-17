package com.MPGI.ECOMSport.EJBentity;

import javax.persistence.*;
/*import javax.persistence.TableGenerator;*/

@Entity
@Table(name = "coordonneescb")
public class CoordonneesCB {

    /*@TableGenerator(name = "employee_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "employee_gen")
    */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCoordonneesCB;

    @ManyToOne
    @JoinColumn(name = "id_compte")
    private Compte compte;

    @Column(name = "Numero")
    private String numero;

    @Column(name = "Date")
    private String date;

    @Column(name = "Crypto")
    private String crypto;

    public int getIdCoordonneesCB() {
        return idCoordonneesCB;
    }

    public void setIdCoordonneesCB(int idCoordonneesCB) {
        this.idCoordonneesCB = idCoordonneesCB;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCrypto() {
        return crypto;
    }

    public void setCrypto(String crypto) {
        this.crypto = crypto;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
        this.compte.addCoordonneesCB(this);
    }

    @Override
    public int hashCode() {
        return idCoordonneesCB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoordonneesCB that = (CoordonneesCB) o;

        return idCoordonneesCB == that.idCoordonneesCB;

    }
}
