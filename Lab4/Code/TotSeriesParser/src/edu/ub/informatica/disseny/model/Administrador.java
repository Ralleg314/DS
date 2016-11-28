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
public class Administrador {
    private Afegir add;
    private String nom,usuari,contrasenya;
    
    public Administrador(String nom, String usuari, String contrasenya){
        this.nom=nom;
        this.usuari=usuari;
        this.contrasenya=contrasenya;
    }
    /**
     *
     * @param usuari
     * @return
     */
    public boolean ferVip(Usuari_registrat usuari){
        return false;
    }
    
    /**
     *
     * @param tipus
     * @return
     */
    public boolean afegir(String tipus){
        return false;
    }
}
