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
    private String titol, descripcio;
    private int num_temp;
    private ArrayList<Temporada> temporades;
    
    public Serie(String titol, int temporades, String descripcio){
        this.titol=titol;
        this.num_temp=temporades;
        this.descripcio=descripcio;
    }
}
