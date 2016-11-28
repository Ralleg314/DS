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
public class Temporada {
    public int numero,episodis;
    public ArrayList eps;
    
    public Temporada(int numero, int episodis){
        this.numero=numero;
        this.episodis=episodis;
        eps=new ArrayList<Episodi>(0);
    }
}
