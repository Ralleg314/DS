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
    private String nom,id,nacionalitat,contrasenya;
    private boolean VIP;
    private Date naixement;
    
    public Usuari_registrat(String nom,String id,String nacionalitat,String contrasenya){
        this.nom=nom;
        this.id=id;
        this.nacionalitat=nacionalitat;
        this.contrasenya=contrasenya;
        this.VIP=false;
        this.naixement=new Date();
    }
    
    public String getId(){
        return id;
    }
    
    public boolean equals(Usuari_registrat usuari){
        return this.id.equals(usuari.getId());
    }
    
}
