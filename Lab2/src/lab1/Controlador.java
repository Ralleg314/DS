/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author EVA-00
 */
public class Controlador {
    private Dades data;
    public Controlador(){
        data=new Dades();
    }
    public void addWorker(String name,int age,String address,String city,float wage){
        if(data.isInWorker(name)==-1)data.addWorker(name, age, address, city, wage);
        else{System.out.println("Already exists");}
    }
    
    public void addClient(String name, String DNI, String opinion){
        if(data.isInClient(name,DNI)==-1)data.addClient(name, DNI,opinion);
        else{System.out.println("Already exists");}
    }
    
    public void addService(String namew, String namec, String DNI, String opinion){
        int posw=data.isInWorker(namew);
        int posc=data.isInClient(namec,DNI);
        if(posc!=-1 && posw!=-1)data.newService(posw, posc);
        else{
            System.out.println("Client or Employee doesn't exist");
        }
    }
    
    public void updateWorker(String name, String type){
        int pos=data.isInWorker(name);
        if(pos!=-1){
            data.updateWorker(pos, type);
        }
    }
    
    public void updateClient(String name, String DNI, String type){
        int pos=data.isInClient(name, DNI);
        if(pos!=-1){
            data.updateClient(pos, type);
        }
    }
}
