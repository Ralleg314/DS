/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.informatica.disseny.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author EVA-00
 */
public class Dades {
    ArrayList<Usuari_registrat> usuaris;
    ArrayList<Administrador> administradors;
    ArrayList<Serie> series;
    ArrayList<Episodi> valorats;
    
    public boolean existeixUsuari(String id){
        for(Usuari_registrat us:usuaris){
            if (us.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
    
    public void registrarUsuari(String nom, String id, String nacionalitat, Date naixament, String password){
        usuaris.add(new Usuari_registrat( nom,  id, nacionalitat,  naixament,  password));
    }
    
    public void visualitzarCataleg(){
        for(Serie ser : series){
            System.out.println(ser.toString());
        }
    }
    
    public void visualitzarTemporades(int s){
        series.get(s).visualitzarTemporades();
    }
    
    public void visualitzarEpisodis(int s, int t){
        series.get(s).visualitzarEpisodis(t);
    }
    
    public void reproduirEpisodi(int s, int t, int ep){
        series.get(s).reproduirEpisodi(t, ep);
    }
    
    public void valorarEpisodi(int s, int t, int ep, int val){
        series.get(s).valorarEpisodi(t, ep, val);
    }

    public void crearSerie(String id, String title, String desc) {
        series.add(new Serie(id,title, desc));
    }
}
