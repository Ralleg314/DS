/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.informatica.disseny.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ralleg
 */
public class Episodi {
    private String nom,idioma,descripcio,duracio;
    private float valoracio;
    private ArrayList<Valoracio> val;
    private Date emisio;
    private Estat_episodi estat;
    
    /**
     *
     */
    public Episodi(){
        this.val=new ArrayList<>();
        this.valoracio=0;        
    }
    
    /**
     *
     * @param nom
     * @param idioma
     * @param descripcio
     * @param duracio
     * @param data
     */
    public Episodi(String nom, String idioma, String descripcio, String duracio, Date data){
        this.nom=nom;
        this.idioma=idioma;
        this.descripcio=descripcio;
        this.duracio=duracio;
        this.val=new ArrayList<>();
        this.valoracio=-1;
        emisio=data;
        this.estat=new Estat_episodi();
    }
    
    /**
     *
     */
    public void reproduirEpisodi(){
        if("PENDENT".equals(estat.getState())){
            reproduir();
        }
    }

    private void reproduir() {
        this.estat.setState("REPRODUINT");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Episodi.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.estat.setState("VIST");
    }

    void valorarEpisodi(Valoracio val) {
        this.val.add(val);
        this.setEstat("VALORAT");
        updateValoracio();
    }
    
    void updateValoracio(){
        valoracio=0;
        for(Valoracio v:val){
            valoracio+=((float)v.getValoracio())/val.size();
        }
    }
    
    /**
     *
     * @return
     */
    public float getVal(){
        return this.valoracio;
    }
    /**
     *
     * @return
     */
    public String toString(){
        return this.nom;
    }

    /**
     *
     * @return
     */
    public String getEstat() {
        return this.estat.getState();
    }
    
    /**
     *
     * @param estat
     */
    public void setEstat(String estat) {
        this.estat.setState(estat);
    }
}
