package com.MPGI.ECOMSport.MgrBean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.MPGI.ECOMSport.EJBentity.Adresse;
import com.MPGI.ECOMSport.EJBsession.AdresseDao;

@ManagedBean(name = "adresseControler")
@RequestScoped
public class AdresseController {


    @EJB
    private AdresseDao adresseDao;

    @PostConstruct
    public void init() {
    	/* Adresse adresse = new Adresse();
        adresse.setActive(true);
        adresse.setLibelle("hello");
        this.saveAdresse(adresse);*/
    }

    public List<Adresse> getAllAdresses() {

        return adresseDao.findAll();
    }

    public void saveAdresse(Adresse newAdresse) {
        System.out.println(adresseDao);
        newAdresse.setActive(true);
        adresseDao.save(newAdresse);
    }

    public Adresse readAdresse(int idclient) {
        return adresseDao.findById(idclient);
    }
}
