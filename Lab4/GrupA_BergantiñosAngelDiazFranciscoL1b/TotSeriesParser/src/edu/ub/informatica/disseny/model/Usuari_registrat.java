/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.informatica.disseny.model;

import java.util.Date;

/**
 *
 * @author ralleg
 */
public class Usuari_registrat extends Usuari{
    private String nom,id,contrasenya;
    private boolean VIP;
    private Date naixement;

    Usuari_registrat(String nom, String dni, String adreca, String usuari, String password, boolean vip) {
        this.nom=nom;
        this.id=usuari;
        this.contrasenya=password;
        this.VIP=vip;
        this.naixement=new Date();
    }

    Usuari_registrat(String nom, String dni, String adreca, String usuari, String password) {
        this.nom=nom;
        this.id=usuari;
        this.contrasenya=password;
        this.VIP=false;
        this.naixement=new Date();
    }
    
    /**
     *
     * @return
     */
    public String getId(){
        return id;
    }
    
    /**
     *
     * @param usuari
     * @return
     */
    public boolean equals(Usuari_registrat usuari){
        return this.id.equals(usuari.getId());
    }
    
}
