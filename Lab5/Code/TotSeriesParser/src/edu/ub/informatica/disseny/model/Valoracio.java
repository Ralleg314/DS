/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.informatica.disseny.model;

import java.util.Date;

/**
 *
 * @author abergaye8.alumnes
 */
public class Valoracio {
    private String id;
    private int valoracio;
    private Date dada;

    Valoracio(String logedUser, int val) {
        this.id=logedUser;
        this.valoracio=val;
        dada=new Date();
    }
    
    /**
     *
     * @return
     */
    public int getValoracio(){
        return valoracio;
    }
}
