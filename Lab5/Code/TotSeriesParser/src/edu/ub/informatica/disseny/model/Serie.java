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
    private int reproduccions;
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
        reproduccions=0;
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
    public ArrayList<Temporada> getTemporades(){
        return this.temporades;
    }
    
    /**
     *
     * @return
     */
    public int getNum_Temporades(){
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

    void afegirEpisodi(Episodi temp, int pos) {
        this.temporades.get(pos).afegirEpisodi(temp);
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
     * @return 
     */
    public ArrayList<String> visualitzarTemporades() {
        ArrayList<String> temp = new ArrayList<>();
        temp.add("Back");
        for(Temporada t : temporades){
            temp.add(t.toString());
        }
        return temp;
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
        this.reproduccions++;
        temporades.get(t).reproduirEpisodi(ep);
    }

    void valorarEpisodi(int t, int ep, Valoracio val) {
        temporades.get(t).valorarEpisodi(ep,val);
    }

    String getEstat(int t, int ep) {
        return temporades.get(t).getEstat(ep);
    }
    
    /**
     *
     * @return
     */
    public int getReproduccions(){
        return this.reproduccions;
    }
    
    /**
     *
     * @return
     */
    public float getVal(){
        float val=0;
        int cont=0;
        for(Temporada t:temporades){
            for(Episodi ep: t.getEps()){
                if(ep.getVal()!=-1){
                    val+=ep.getVal();
                    cont++;
                }
            }
        }
        if(cont!=0){
            return val/cont;
        }else{
            return 0;
        }
    }
}
