/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.informatica.disseny.vista;
import edu.ub.informatica.disseny.totseries.Consola;
import java.util.Scanner;
import edu.ub.informatica.disseny.totseries.TotSeriesDataManager;

/**
 *
 * @author ralleg
 */
public class vista {
    
    /**
     *
     * @param args
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        TotSeriesDataManager dataManager = new TotSeriesDataManager();
        dataManager.obtenirDades("data/TotSeries.xml");
        int op, op2;
        
        do{
            System.out.println("Menu Principal"); 
            System.out.println("-----------------------");
            System.out.println("[1] Registrar-se"); 
            System.out.println("[2] Visualitzar Cataleg"); 
            System.out.println("[3] Visualitzar Episodi");
            System.out.println("[4] Visualitzar Episodis més valorats");
            System.out.println("[5] Sortir");
            System.out.println("-----------------------");
            System.out.println("Selection: "); 
            op=Consola.llegeixInt();
        
            switch (op){

               case 1:System.out.println("Registrar-se:");
                    System.out.println("Nickname: "); 
                    String id=Consola.llegeixString();
                    System.out.println("Nom: ");
                    String nom=Consola.llegeixString();
                    System.out.println("Adreça: ");
                    String adreca=Consola.llegeixString();
                    System.out.println("DNI: ");
                    String dni=Consola.llegeixString();
                    System.out.println("Contrasenya: ");
                    String contra=Consola.llegeixString();
                    dataManager.crearClient(nom, dni, adreca, id, contra);
                    break;

                case 2:System.out.println("Visualitzar Catàleg");
                    dataManager.mostratCataleg();
                    break;
                
                case 3: 
                    System.out.println("Visualitzar Episodi ");
                    dataManager.mostratCataleg();
                    System.out.println("Serie: ");
                    int s=Consola.llegeixInt()-1;
                    dataManager.mostratTemporades(s);
                    break;
                
                case 4:
                    System.out.println("Visualitzar Episodis mes valorats");
                    
                    break;
                
                case 5:System.out.println("Exit Successful");
                    break;

                default:System.out.println("Please enter a valid selection.");

                };
        }while(op!=5);
        
    }
}
