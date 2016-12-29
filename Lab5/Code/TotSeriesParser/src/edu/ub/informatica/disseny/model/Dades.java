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
    ArrayList<Serie> series,valorats,vists;
    ArrayList<Episodi> episodis;
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
        episodis=new ArrayList<>();
        valorats=new ArrayList<>();
        productores=new ArrayList<>();
        artistes=new ArrayList<>();
        logedUser="";
    }
    
    /**
     *
     * @return
     */
    public static Dades getInstance(){
        if(instance==null){
            instance=new Dades();
        }
        return instance;
    }
    
    /**
     *
     * @return
     */
    public ArrayList getSeries(){
        return series;
    }

    /**
     *
     * @return
     */
    public ArrayList getValorats(){
        return valorats;
    }

    /**
     *
     * @return
     */
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
    
    /**
     *
     * @param id
     * @return
     */
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
    
    /**
     *
     * @return
     */
    public String getLogedUser(){
        return this.logedUser;
    }
    
    /**
     *
     * @param us
     */
    public void setLogedUser(String us){
        this.logedUser=us;
    }
    
    /**
     *
     * @param pos
     * @param pass
     * @return
     */
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
     */
    @SuppressWarnings("empty-statement")
    public void omplirEpisodis(){
        for (Serie s: series){
            for(Temporada t: s.getTemporades()){
                for(Episodi e: t.getEps()){
                    episodis.add(e);
                };
            } 
        }
    }
    
    /**
     *
     */
    public void omplirValorats(){
        ArrayList<Serie> temp=new ArrayList<>(series);
        valorats = new ArrayList<>();
        int i,pos;
        float valAct,max;
        while(!temp.isEmpty()){
            i=0;
            pos=0;
            max=-1;
            for (Serie s: temp){
                valAct=s.getVal();
                if (valAct>max){
                    max=valAct;
                    pos=i;
                }
                i++;
            }
            valorats.add(temp.get(pos));
            temp.remove(pos);
        }
    }
    
    /**
     *
     * @return
     */
    public ArrayList<String> visualitzarValorats(){
        ArrayList<String> temp= new ArrayList<>();
        omplirValorats();
        for (Serie ep: valorats){
            temp.add(ep.getVal()+"    "+ep.toString());
        }return temp;
    }
    
    /**
     *
     */
    public void omplirVists(){
        ArrayList<Serie> temp=new ArrayList<>(series);
        vists = new ArrayList<>();
        int i,pos,max, valAct;
        while(!temp.isEmpty()){
            i=0;
            pos=0;
            max=-1;
            for (Serie s: temp){
                valAct=s.getReproduccions();
                if (valAct>max){
                    max=valAct;
                    pos=i;
                }
                i++;
            }
            vists.add(temp.get(pos));
            temp.remove(pos);
        }
    }
    
    /**
     *
     * @return
     */
    public ArrayList<String> visualitzarVists(){
        ArrayList<String> temp= new ArrayList<>();
        omplirVists();
        for (Serie s: vists){
            temp.add(s.getReproduccions()+"    "+s.toString());
        }return temp;
    }
    
    /**
     *
     * @param s
     * @return 
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
        if(this.getEstat(s,t,ep)=="VIST"){
            series.get(s).valorarEpisodi(t, ep, new Valoracio(this.logedUser,val));
        }
    }
    
    /**
     *
     * @param s
     * @param t
     * @param ep
     * @return
     */
    public String getEstat(int s, int t, int ep) {
        return series.get(s).getEstat(t, ep);
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
            this.episodis.add(temp);
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
