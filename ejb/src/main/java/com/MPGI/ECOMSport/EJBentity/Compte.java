package com.MPGI.ECOMSport.EJBentity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/*import javax.persistence.TableGenerator;*/

@Entity
@Table(name = "compte")
public class Compte {

    /*@TableGenerator(name = "employee_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "employee_gen")
    */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idClient;

    @OneToMany(mappedBy = "compte")
    private List<CoordonneesCB> coordonneesCBs;

    @Column(name = "Login")
    private String login;

    @Column(name = "MDP")
    private String mdp;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Prenom")
    private String prenom;

    @Column(name = "Email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_adresse")
    private Adresse adresse;

    public Compte() {
        this.coordonneesCBs = new ArrayList<CoordonneesCB>();
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void addCoordonneesCB(CoordonneesCB coordonneesCB) {
        if (coordonneesCBs.contains(coordonneesCB)) {
            return;
        }
        this.coordonneesCBs.add(coordonneesCB);
    }

    public void removeCoordonneesCB(CoordonneesCB coordonneesCB) {
        if (!coordonneesCBs.contains(coordonneesCB)) {
            return;
        }
        this.coordonneesCBs.remove(coordonneesCB);
    }

    public List<CoordonneesCB> getCoordonneesCBs() {
        return coordonneesCBs;
    }

    public void setCoordonneesCBs(List<CoordonneesCB> coordonneesCBs) {
        this.coordonneesCBs = coordonneesCBs;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        return idClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Compte compte = (Compte) o;

        return idClient == compte.idClient;

    }
}
