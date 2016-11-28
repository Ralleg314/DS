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
public class Episodi {
    private String nom,idioma,descripcio;
    private float duracio, valoracio;
    private Date emisio;
    
    public Episodi(String nom, String idioma, String descripcio, float duracio, float valoracio){
        this.nom=nom;
        this.idioma=idioma;
        this.descripcio=descripcio;
        this.duracio=duracio;
        this.valoracio=valoracio;
        emisio=new Date();
        
    }
    
    public void reproduirEpisodi(){
        
    }
}
