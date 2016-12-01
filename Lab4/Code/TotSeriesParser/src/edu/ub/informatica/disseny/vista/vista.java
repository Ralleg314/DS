/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.informatica.disseny.vista;
import java.util.Scanner;
import edu.ub.informatica.disseny.totseries.TotSeriesDataManager;

/**
 *
 * @author ralleg
 */
public class vista {
    
    
     
    public static void main(String[] args) {
        TotSeriesDataManager dataManager = new TotSeriesDataManager();
        dataManager.obtenirDades("data/TotSeries.xml");
        Scanner sc=new Scanner(System.in);
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
            op=sc.nextInt();
        
            switch (op){

               case 1:System.out.println("Registrar-se:");
                    System.out.println("Nickname: "); 
                    String id=sc.next();
                    System.out.println("Nom: ");
                    String nom= sc.next();
                    System.out.println("Adreça: ");
                    String adreca= sc.next();
                    System.out.println("Contrasenya: ");
                    String contra= sc.next();
                    //obviamente esto no esta bien.
                    dataManager.crearClient(id, nom, nom, adreca, contra, contra, id);
                    break;

                case 2:System.out.println("Visualitzar Catàleg");
                    dataManager.mostratCataleg();
                    break;
                
                case 3: 
                    System.out.println("Visualitzar Episodi ");
                    
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
