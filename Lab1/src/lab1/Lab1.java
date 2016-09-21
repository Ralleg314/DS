/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.ArrayList;
import java.util.Arrays;
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
        ArrayList<Worker> employees=new ArrayList<>();
        ArrayList<Client> clients=new ArrayList<>();
        String name;
        int age;
        String address;
        String city;
        float wage;
        String tutor;
        String DNI;
        String opinion;
        Scanner sc=new Scanner(System.in);
           
        int test;
        do{
            System.out.println("Please Make a selection:"); 
            System.out.println("[1] Add worker"); 
            System.out.println("[2] Add service"); 
            System.out.println("[3] Exit"); 
            System.out.println("Selection: "); 
            test=sc.nextInt();
        
            switch (test){

               case 1:System.out.println("Please Make a selection:");
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
                    if(age<18){
                        System.out.println("Tutor:"); 
                        tutor=sc.next();
                        employees.add(new Minor(name,age,address,city,wage,tutor));
                    }else{
                        employees.add(new Adult(name,age,address,city,wage));
                    }
                    break;

                case 2:System.out.println("Add service");
                    System.out.println("Name:");
                    name=sc.next();
                    System.out.println("DNI:");
                    DNI=sc.next();
                    System.out.println("Opinion:");
                    opinion=sc.next();
                    boolean end=true;
                    Client temp=new Client(name, DNI, opinion);
                    for(Client i:clients){
                        if(temp.equals(i)){
                            i.newService(opinion);
                            end=false;
                            break;
                        }
                    }
                    if(end)clients.add(temp);
                    end=true;
                    break;

                case 3:System.out.println("Exit Successful");
                    break;

                default:System.out.println("Please enter a valid selection.");

                };
        }while(test!=3);
    }
    
}
