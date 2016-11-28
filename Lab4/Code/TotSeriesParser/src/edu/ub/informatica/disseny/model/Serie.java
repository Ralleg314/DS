/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.informatica.disseny.model;

/**
 *
 * @author ralleg
 */
public class Serie {
    public String titol, descripcio;
    public int temporades;
    
    public Serie(String titol, int temporades, String descripcio){
        this.titol=titol;
        this.temporades=temporades;
        this.descripcio=descripcio;
    }
}
