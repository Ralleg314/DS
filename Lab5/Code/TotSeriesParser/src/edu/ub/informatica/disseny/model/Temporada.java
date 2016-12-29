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
public class Temporada {
    private int numero,episodis;
    private ArrayList<Episodi> eps;
    
    /**
     *
     * @param numero
     * @param episodis
     */
    public Temporada(int numero, int episodis){
        this.numero=numero;
        this.episodis=episodis;
        eps=new ArrayList<>(0);
    }

    /**
     *
     * @return 
     * @return  
     */
    public ArrayList<String> visualitzarEpisodis() {
        ArrayList<String> temp = new ArrayList<>();
        temp.add("Back");
        for(Episodi t : eps){
            temp.add(t.toString());
        }
        return temp;
    }

    void reproduirEpisodi(int ep) {
        eps.get(ep).reproduirEpisodi();
    }

    void valorarEpisodi(int ep, Valoracio val) {
        eps.get(ep).valorarEpisodi(val);
    }

    void afegirEpisodi(Episodi temp) {
        this.eps.add(temp);
        episodis++;
    }
    
    /**
     *
     * @return
     */
    public int getEpisodis(){
        return this.episodis;
    }
    
    public ArrayList<Episodi> getEps(){
        return this.eps;
    }
    /**
     *
     * @param ep
     * @return
     */
    public Episodi getEp(int ep){
        return this.eps.get(ep);
    }
    
    /**
     *
     * @return
     */
    public String toString(){
        return Integer.toString(this.numero);
    }

    String getEstat(int ep) {
        return this.eps.get(ep).getEstat();
    }
}
