package com.MPGI.ECOMSport.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.MPGI.ECOMSport.EJBentity.Compte;



@ManagedBean(name = "compteForm")
@RequestScoped
public class CompteForm extends Compte {
}
