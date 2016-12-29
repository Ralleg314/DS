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
    private static Dades instance = null;
    ArrayList<Usuari_registrat> usuaris;
    ArrayList<Administrador> administradors;
    ArrayList<Serie> series;
    ArrayList<Episodi> valorats;
    ArrayList<Productora> productores;
    ArrayList<Artista> artistes;
    String logedUser;
    
    /**
     *
     */
    private Dades(){
        usuaris=new ArrayList<>();
        administradors=new ArrayList<>();
        series=new ArrayList<>();
        valorats=new ArrayList<>();
        productores=new ArrayList<>();
        artistes=new ArrayList<>();
    }
    
    public static Dades getInstance(){
        if(instance==null){
            instance=new Dades();
        }
        return instance;
    }
    
    public ArrayList getSeries(){
        return series;
    }
    public ArrayList getValorats(){
        return valorats;
    }
    public ArrayList getVists(){
        return series;
    }
    /**
     *
     * @param id
     * @return
     */
    public boolean existeixUsuari(String id){
        for(Usuari_registrat us:usuaris){
            if (us.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
    
    public int posUsuari(String id){
        int i=0;
        for(Usuari_registrat us:usuaris){
            if (us.getId().equals(id)){
                return i;
            }
            i++;
        }
        return -1;
    }
    
    public String getLogedUser(){
        return this.logedUser;
    }
    
    public void setLogedUser(String us){
        this.logedUser=us;
    }
    
    public boolean comprovarPassword(int pos, String pass){
        return this.usuaris.get(pos).getPassword().equals(pass);
    }
    
    /**
     *
     * @return 
     */
    public ArrayList<String> visualitzarCataleg(){
        ArrayList<String> temp=new ArrayList<>();
        for(Serie ser : series){
            temp.add(ser.toString());
        }
        return temp;
    }
    
    /**
     *
     * @param s
     */
    public ArrayList<String> visualitzarTemporades(int s){
        return series.get(s).visualitzarTemporades();
    }
    
    /**
     *
     * @param s
     * @param t
     * @return 
     */
    public ArrayList<String> visualitzarEpisodis(int s, int t){
        return series.get(s).getTemp(t).visualitzarEpisodis();
    }
    
    /**
     *
     * @param s
     * @param t
     * @param ep
     */
    public void reproduirEpisodi(int s, int t, int ep){
        series.get(s).reproduirEpisodi(t, ep);
    }
    
    /**
     *
     * @param s
     * @param t
     * @param ep
     * @param val
     */
    public void valorarEpisodi(int s, int t, int ep, int val){
        series.get(s).valorarEpisodi(t, ep, new Valoracio(this.logedUser,val));
    }

    /**
     *
     * @param id
     * @param title
     * @param desc
     */
    public void crearSerie(String id, String title, String desc) {
        series.add(new Serie(id,title, desc));
    }

    /**
     *
     * @param numTemporada
     * @param numEpisodis
     * @param i
     */
    public void crearTemporada(String numTemporada, String numEpisodis, int i) {
        Temporada temp=new Temporada(Integer.parseInt(numTemporada),Integer.parseInt(numEpisodis));
        series.get(i).afegirTemporada(temp);
    }

    /**
     *
     * @param title
     * @param duration
     * @param idioma
     * @param description
     * @param data
     * @param i
     * @param j
     */
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

    /**
     *
     * @param id
     * @param nom
     * @param usuari
     * @param password
     */
    public void afegirAdmin(String id, String nom, String usuari, String password) {
        this.administradors.add(new Administrador(id,nom,usuari,password));
    }

    /**
     *
     * @param tipus
     * @param id
     * @param nom
     * @param idSerie
     * @param nacionalitat
     */
    public void afegirArtista(String tipus, String id, String nom, String idSerie, String nacionalitat) {
        if(tipus.equals("Actor")){
            this.artistes.add(new Actor(id,nom,nacionalitat));
        }else{
            this.artistes.add(new Director(id,nom,nacionalitat));
        }
    }

    /**
     *
     * @param id
     * @param nom
     * @param idSerie
     */
    public void afegirProductora(String id, String nom, String idSerie) {
        this.productores.add(new Productora(id,nom));
    }

    /**
     *
     * @param nom
     * @param dni
     * @param adreca
     * @param usuari
     * @param password
     * @param vip
     */
    public void registrarUsuari(String nom, String dni, String adreca, String usuari, String password, String vip) {
        Usuari_registrat temp=new Usuari_registrat(nom,dni,adreca,usuari,password);
        if(!this.existeixUsuari(temp.getId())){
            this.usuaris.add(new Usuari_registrat(nom,dni,adreca,usuari,password,Boolean.valueOf(vip)));
        }
    }

    /**
     *
     * @param nom
     * @param dni
     * @param adreca
     * @param usuari
     * @param password
     */
    public void registrarUsuari(String nom, String dni, String adreca, String usuari, String password) {
        Usuari_registrat temp=new Usuari_registrat(nom,dni,adreca,usuari,password);
        if(!this.existeixUsuari(temp.getId())){
            this.usuaris.add(new Usuari_registrat(nom,dni,adreca,usuari,password));
        }
    }
}
