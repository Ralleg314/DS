/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.ArrayList;
import java.util.Scanner;
import javafx.util.Pair;

/**
 *
 * @author EVA-00
 */
public class Dades {
    private ArrayList<Worker> workers=new ArrayList<>();
    private ArrayList<Client> clients=new ArrayList<>();
    private ArrayList<Service> services=new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    
    public void addWorker(String name,int age,String address,String city,float wage){
        if(age<18){
            System.out.println("Tutor:"); 
            String tutor=sc.next();
            workers.add(new Minor(name,age,address,city,wage,tutor));
        }else{
            workers.add(new Adult(name,age,address,city,wage));
        }
    }
    
    public void addClient(String name, String DNI, String opinion){
        clients.add(new Client(name,DNI,opinion));
    }
    
    public void updateWorker(int pos, String type){
        switch(type){
            case "name":
                System.out.println("Name:"); 
                workers.get(pos).setName(sc.next());
                break;
            case "age":
                System.out.println("Age:"); 
                workers.get(pos).setAge(sc.nextInt());
                break;
            case "address":
                System.out.println("Address:");
                workers.get(pos).setAddress(sc.next());
                break;
            case "city":
                System.out.println("City:");
                workers.get(pos).setCity(sc.next());
                break;
            case "wage":
                System.out.println("Wage:");
                workers.get(pos).setWage(sc.nextFloat());
                break;
            case "tutor":
                if(workers.get(pos) instanceof Minor){
                    Minor temp=(Minor)workers.get(pos);
                    System.out.println("Tutor:");
                    temp.setTutor(sc.next());
                }else{
                    System.out.println("Not a minor");
                }
                break;
            case "default":
                System.out.println("Unknown type");
                break;
        }
    }
    
    public void updateClient(int pos, String type){
        switch(type){
            case "age":
                System.out.println("Name:"); 
                clients.get(pos).setName(sc.next());
                break;
            case "DNI":
                System.out.println("DNI:");
                clients.get(pos).setDNI(sc.next());
                break;
        }
    }
    
    public void newService(int posw, int posc){
        services.add(new Service(workers.get(posw),clients.get(posc)));
    }
    
    public int isInWorker(String name){
        int i=0;
        Worker temp=new Worker(name); 
        for(Worker w:workers){
            if(temp.equals(w)){
                return i;
            }
            i++;
        }
        return -1;
    }
    
    public int isInClient(String name, String DNI){
        int i=0;
        Client temp=new Client(name,DNI); 
        for(Client c:clients){
            if(c.equals(temp))return i;
            i++;
        }
        return -1;
    }
}
