/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.informatica.disseny.model;

/**
 *
 * @author ralleg
 */
public abstract class Artista {
    private String id;
    private String nom;
    private String nacionalitat;
    
    public Artista(String id, String nom, String nacionalitat){
        this.id=id;
        this.nom=nom;
        this.nacionalitat=nacionalitat;
    }
}
