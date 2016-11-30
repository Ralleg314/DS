/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.informatica.disseny.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ralleg
 */
public class Episodi {
    private String nom,idioma,descripcio;
    private float duracio, valoracio;
    private ArrayList<Integer> val;
    private Date emisio;
    private Estat_episodi estat;
    
    public Episodi(String nom, String idioma, String descripcio, float duracio, float valoracio){
        this.nom=nom;
        this.idioma=idioma;
        this.descripcio=descripcio;
        this.duracio=duracio;
        this.val=new ArrayList<>();
        this.valoracio=valoracio;
        emisio=new Date();
        
    }
    
    public void reproduirEpisodi(){
        if(estat.PENDENT){
            reproduir();
            //To make everything easier, we will consider that state changes to SEEN ones reproduir() ends
            estat.VIST=true;
        }
    }

    private void reproduir() {
    }

    void valorarEpisodi(int val) {
        this.val.add(val);
        valoracio+=val;
        valoracio/=this.val.size();
    }
}
