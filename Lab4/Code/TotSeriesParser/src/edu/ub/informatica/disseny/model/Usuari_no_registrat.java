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
public class Usuari_no_registrat extends Usuari{
    public static boolean intentaRegistrar(String ID){
        return false;
    }
}
