package com.MPGI.ECOMSport.MgrBean;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.MPGI.ECOMSport.EJBentity.Compte;
import com.MPGI.ECOMSport.EJBsession.CompteDao;
import com.MPGI.ECOMSport.beans.CompteRegister;
import com.MPGI.ECOMSport.beans.CompteSession;

@ManagedBean(name = "compteController")
@RequestScoped
public class CompteController {

    @EJB
    private CompteDao compteDao;


    /*
    On doit récuperer le bean CompteSession via jsf car c'est lui qui s'est chargé de l'instancier 
     */
    public static CompteSession getCurrentCompte() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return (CompteSession) facesContext.getExternalContext().getSessionMap().get("compteSession");
    }

    
    @PostConstruct
    public void init() {
        String login = "testUser";
        String mdp = "password";
        Compte compteDao = this.compteDao.findByLogin(login);
        if (compteDao != null) {
            return;
        }
        Compte compte = new Compte();
        compte.setPrenom("jojo");
        compte.setNom("lapin");
        compte.setLogin(login);
        compte.setMdp(mdp);
        compte.setEmail("jojo.lapin@plush.io");
        this.compteDao.save(compte);

    }

    public void logout() {
        Compte compteSession = getCurrentCompte();
        compteSession.setAdresse(null);
        compteSession.setCoordonneesCBs(null);
        compteSession.setEmail(null);
        compteSession.setIdClient(0);
        compteSession.setLogin(null);
        compteSession.setMdp(null);
        compteSession.setNom(null);
        compteSession.setPrenom(null);
    }

    public void login(Compte compteForm) {
        Compte compteSession = getCurrentCompte();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Compte compteFromDao = this.compteDao.findByLogin(compteForm.getLogin());
        if (compteFromDao == null) {
            //here it's show error on growl notifier from primefaces but in normal jsf it can be use as a error label output
            facesContext.addMessage("login",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur de connexion", "utilisateur non trouvé")
            );
            return;
        }
        if (!compteFromDao.getMdp().equals(compteForm.getMdp())) {
            facesContext.addMessage("login",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur de connexion", "le mot de passe ne correspond pas")
            );
            return;
        }

        compteSession.setAdresse(compteFromDao.getAdresse());
        compteSession.setCoordonneesCBs(compteFromDao.getCoordonneesCBs());
        compteSession.setEmail(compteFromDao.getEmail());
        compteSession.setIdClient(compteFromDao.getIdClient());
        compteSession.setLogin(compteFromDao.getLogin());
        compteSession.setMdp(compteFromDao.getMdp());
        compteSession.setNom(compteFromDao.getNom());
        compteSession.setPrenom(compteFromDao.getPrenom());

        facesContext.addMessage("login",
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Connexion réussie", "")
        );
    }
	
    public String saveUser(CompteRegister compte){
    	Compte compte2 = new Compte();
    	compte2.setAdresse(compte.getAdresse());
    	compte2.setCoordonneesCBs(compte.getCoordonneesCBs());
    	compte2.setEmail(compte.getEmail());
    	compte2.setIdClient(compte.getIdClient());
    	compte2.setLogin(compte.getLogin());
    	compte2.setNom(compte.getNom());
    	compte2.setPrenom(compte.getPrenom());
    	compte2.setMdp(compte.getMdp());
    	compteDao.save(compte2);
		return "CompteCreate";
	}
}
