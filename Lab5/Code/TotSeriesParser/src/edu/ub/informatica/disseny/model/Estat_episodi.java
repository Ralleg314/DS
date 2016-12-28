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
    int estat;
    
    /**
     *
     */
    public Estat_episodi(){
        estat=0;
    }
    
    public String getState(){
        switch(estat){
            case 0:
                return "PENDENT";
            case 1:
                return "PENDENT";
            case 2:
                return "PENDENT";
        }
        return "";
    }
}
