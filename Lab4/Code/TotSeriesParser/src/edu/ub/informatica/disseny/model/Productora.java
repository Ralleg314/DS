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
public class Productora {
    private String nom,id;
    private Date creacio;
    
    public Productora(String nom, String id){
        this.nom=nom;
        this.id=id;
        creacio=new Date();
    }
}
