package com.MPGI.ECOMSport.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.MPGI.ECOMSport.EJBentity.Compte;
import com.MPGI.ECOMSport.EJBsession.CompteDao;



@ManagedBean(name = "compteRegister")
@RequestScoped
public class CompteRegister extends Compte {
}
