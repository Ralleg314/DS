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
public class Estat_episodi {
    boolean VIST;
    boolean REPRODUINT;
    boolean PENDENT;
    
    public Estat_episodi(){
        VIST=false;
        REPRODUINT=false;
        PENDENT=true;
    }
}
