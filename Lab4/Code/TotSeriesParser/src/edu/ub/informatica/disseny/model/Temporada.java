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
    
    public Temporada(int numero, int episodis){
        this.numero=numero;
        this.episodis=episodis;
        eps=new ArrayList<>(0);
    }

    public void visualitzarEpisodis() {
        for(Episodi ep : eps){
            System.out.println(ep.toString());
        }
    }

    void reproduirEpisodi(int ep) {
        eps.get(ep).reproduirEpisodi();
    }

    void valorarEpisodi(int ep, int val) {
        eps.get(ep).valorarEpisodi(val);
    }
}
