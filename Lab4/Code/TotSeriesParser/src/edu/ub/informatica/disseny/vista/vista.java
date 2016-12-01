/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.informatica.disseny.vista;

import edu.ub.informatica.disseny.totseries.TotSeriesDataManager;

/**
 *
 * @author ralleg
 */
public class vista {
    public static void main(String[] args) {
        TotSeriesDataManager dataManager = new TotSeriesDataManager();
        dataManager.obtenirDades("data/TotSeries.xml");
        
    }
}
