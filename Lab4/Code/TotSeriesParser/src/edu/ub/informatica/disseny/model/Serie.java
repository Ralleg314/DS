/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.informatica.disseny.model;

import java.util.ArrayList;

/**
 *
 * @author ralleg
 */
public class Serie {
    private String id, titol, descripcio;
    private int num_temp;
    private ArrayList<Temporada> temporades;
    private ArrayList<Artista> artistes;
    private Productora productora;
    
    public Serie(String id, String titol, String descripcio){
        this.id=id;
        this.titol=titol;
        this.num_temp=0;
        this.descripcio=descripcio;
    }
    
    public String toString(){
        return titol;
    }

    public void visualitzarTemporades() {
        for(Temporada t : temporades){
            System.out.println(t.toString());
        }
    }

    public void visualitzarEpisodis(int t) {
        temporades.get(t).visualitzarEpisodis();
    }

    public void reproduirEpisodi(int t, int ep) {
        temporades.get(t).reproduirEpisodi(ep);
    }

    void valorarEpisodi(int t, int ep, int val) {
        temporades.get(t).valorarEpisodi(ep,val);
    }
}
