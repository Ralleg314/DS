/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.ArrayList;
import java.util.Scanner;



/**
 *
 * @author abergaye8.alumnes
 */
public class Lab1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controlador cont=new Controlador();
        String name;
        String namec;
        int age;
        String address;
        String city;
        float wage;
        String tutor;
        String DNI;
        String opinion;
        String type;
        int birthday;
        Scanner sc=new Scanner(System.in);
           
        int test;
        int test2;
        do{
            System.out.println("Please Make a selection:"); 
            System.out.println("[1] Worker"); 
            System.out.println("[2] Client"); 
            System.out.println("[3] Exit"); 
            System.out.println("Selection: "); 
            test=sc.nextInt();
        
            switch (test){

               case 1:System.out.println("Employee:");
                    System.out.println("[1] Add worker"); 
                    System.out.println("[2] Update worker"); 
                    System.out.println("Selection: "); 
                    test2=sc.nextInt();
                    switch(test2){
                        case 1:
                            System.out.println("Name:"); 
                            name=sc.next();
                            System.out.println("Age:"); 
                            age=sc.nextInt();
                            System.out.println("Address:"); 
                            address=sc.next();
                            System.out.println("City:"); 
                            city=sc.next();
                            System.out.println("Wage:"); 
                            wage=sc.nextFloat();
                            cont.addWorker(name, age, address, city, wage);
                            break;
                        case 2:
                            System.out.println("Name:");
                            name=sc.next();
                            System.out.println("Type:");
                            type=sc.next();
                            cont.updateWorker(name, type);
                            break;
                    }
                    break;

                case 2:System.out.println("New service(If you want to update information, write the name)");
                    System.out.println("[1] Add client"); 
                    System.out.println("[2] Update client");
                    System.out.println("[3] New service");
                    System.out.println("Selection: "); 
                    test2=sc.nextInt();
                    switch(test2){
                        case 1:
                            System.out.println("Name:");
                            name=sc.next();
                            System.out.println("DNI:");
                            DNI=sc.next();
                            System.out.println("Opinion:");
                            opinion=sc.next();
                            System.out.println("Birthday:");
                            birthday=sc.nextInt();
                            cont.addClient(name,DNI,opinion,birthday);
                            break;
                        case 2:
                            System.out.println("Name:");
                            name=sc.next();
                            System.out.println("DNI:");
                            DNI=sc.next();
                            System.out.println("Type:");
                            type=sc.next();
                            cont.updateClient(name, DNI, type);
                            break;
                        case 3:
                            System.out.println("Worker name:");
                            name=sc.next();
                            System.out.println("Client name:");
                            namec=sc.next();
                            System.out.println("Client's DNI:");
                            DNI=sc.next();
                            System.out.println("Opinion:");
                            opinion=sc.next();
                            cont.addService(name, namec, DNI, opinion);
                            break;
                    }
                    break;

                case 3:System.out.println("Exit Successful");
                    break;

                default:System.out.println("Please enter a valid selection.");

                };
        }while(test!=3);
    }
    
}
