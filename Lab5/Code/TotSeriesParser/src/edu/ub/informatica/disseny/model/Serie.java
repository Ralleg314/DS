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
    
    /**
     *
     */
    public Serie(){
        temporades=new ArrayList<>();
        artistes=new ArrayList<>();
    }
    
    /**
     *
     * @param id
     * @param titol
     * @param descripcio
     */
    public Serie(String id, String titol, String descripcio){
        this.id=id;
        this.titol=titol;
        this.num_temp=0;
        this.descripcio=descripcio;
        temporades=new ArrayList<>();
        artistes=new ArrayList<>();
    }
    
    /**
     *
     * @param temp
     */
    public void afegirTemporada(Temporada temp){
        this.temporades.add(temp);
        num_temp++;
    }
    
    /**
     *
     * @return
     */
    public int getTemporades(){
        return this.num_temp;
    }
    
    /**
     *
     * @param t
     * @return
     */
    public Temporada getTemp(int t){
        return this.temporades.get(t);
    }

    void afegirEpisodi(Episodi temp, int j) {
        this.temporades.get(j).afefirEpisodi(temp);
    }
    
    /**
     *
     * @return
     */
    public String toString(){
        return titol;
    }

    /**
     *
     */
    public void visualitzarTemporades() {
        int i=1;
        for(Temporada t : temporades){
            System.out.println("["+i+"] "+t.toString());
            i++;
        }
    }

    /**
     *
     * @param t
     */
    public void visualitzarEpisodis(int t) {
        temporades.get(t).visualitzarEpisodis();
    }

    /**
     *
     * @param t
     * @param ep
     */
    public void reproduirEpisodi(int t, int ep) {
        temporades.get(t).reproduirEpisodi(ep);
    }

    void valorarEpisodi(int t, int ep, Valoracio val) {
        temporades.get(t).valorarEpisodi(ep,val);
    }
}
