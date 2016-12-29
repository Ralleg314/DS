/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.informatica.disseny.model;

import edu.ub.informatica.disseny.totseries.Consola;
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
    private int reproduccions;
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
        this.valoracio=0;
        emisio=data;
        this.estat=new Estat_episodi();
        this.reproduccions=0;
    }
    
    /**
     *
     */
    public void reproduirEpisodi(){
        if("PENDENT".equals(estat.getState())){
            reproduir();
            //To make everything easier, we will consider that state changes to SEEN ones reproduir() ends
            estat.setState("PENDENT");
        }
    }

    private void reproduir() {
        this.reproduccions++;
        Consola.escriu("Reproduint: "+this.nom+"\n");
        this.estat.setState("REPRODUINT");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Episodi.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.estat.setState("VIST");
    }
    
    /**
     *
     * @return
     */
    public int getReproduccions(){
        return this.reproduccions;
    }

    void valorarEpisodi(Valoracio val) {
        this.val.add(val);
        updateValoracio();
    }
    
    void updateValoracio(){
        for(Valoracio v:val){
            valoracio+=((float)v.getValoracio())/val.size();
        }
    }
    
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
