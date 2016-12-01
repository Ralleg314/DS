/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.informatica.disseny.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EVA-00
 */
public class Dades {
    ArrayList<Usuari_registrat> usuaris;
    ArrayList<Administrador> administradors;
    ArrayList<Serie> series;
    ArrayList<Episodi> valorats;
    ArrayList<Productora> productores;
    ArrayList<Artista> artistes;
    
    public Dades(){
        usuaris=new ArrayList<>();
        administradors=new ArrayList<>();
        series=new ArrayList<>();
        valorats=new ArrayList<>();
        productores=new ArrayList<>();
        artistes=new ArrayList<>();
    }
    
    public boolean existeixUsuari(String id){
        for(Usuari_registrat us:usuaris){
            if (us.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
    
    public void registrarUsuari(String nom, String id, String nacionalitat, String password){
        usuaris.add(new Usuari_registrat( nom,  id, nacionalitat,  password));
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

    public void crearTemporada(String numTemporada, String numEpisodis, int i) {
        Temporada temp=new Temporada(Integer.parseInt(numTemporada),Integer.parseInt(numEpisodis));
        series.get(i).afegirTemporada(temp);
    }

    public void crearEpisodi(String title, String duration, String idioma, String description, String data, int i, int j) {
        
        Date date;
        try {
            date = (new SimpleDateFormat("dd/mm/yyyy")).parse(data);
            Episodi temp=new Episodi(title,idioma,description,duration,date);
            this.series.get(i).afegirEpisodi(temp,j);
        } catch (ParseException ex) {
            Logger.getLogger(Dades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void afegirAdmin(String id, String nom, String usuari, String password) {
        this.administradors.add(new Administrador(id,nom,usuari,password));
    }

    public void afegirArtista(String tipus, String id, String nom, String idSerie, String nacionalitat) {
        if(tipus.equals("Actor")){
            this.artistes.add(new Actor(id,nom,nacionalitat));
        }else{
            this.artistes.add(new Director(id,nom,nacionalitat));
        }
    }

    public void afegirProductora(String id, String nom, String idSerie) {
        this.productores.add(new Productora(id,nom));
    }
}
