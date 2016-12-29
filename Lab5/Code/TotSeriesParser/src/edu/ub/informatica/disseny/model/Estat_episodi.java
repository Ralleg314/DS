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
                return "REPRODUINT";
            case 2:
                return "VIST";
        }
        return "";
    }
    
    public String setState(String estat){
        switch(estat){
            case "PENDENT":
                this.estat=0;
                break;
            case "REPRODUINT":
                this.estat=1;
                break;
            case "VIST":
                this.estat=2;
                break;
        }
        return "";
    }
}
