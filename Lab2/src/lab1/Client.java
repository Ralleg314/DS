package lab1;

import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abergaye8.alumnes
 */
public class Client {
    private String name;
    private String DNI;
    private ArrayList<Date> lastService;
    private ArrayList<String> opinion;
    private int birthday;
    private int services;
    
    public Client(String name, String DNI) {
        this.name=name;
        this.DNI=DNI;
        this.lastService = new ArrayList<>();
        this.opinion=new ArrayList<>();
        services=-1;
    }

    public Client(String name, String DNI,String opinion,int birthday) {
        this.name=name;
        this.DNI=DNI;
        this.lastService = new ArrayList<>();
        this.lastService.add(new Date());
        this.opinion=new ArrayList<>();
        this.opinion.add(opinion);
        this.birthday=birthday;
        services=1;
    }

    public void newService(String opinion){
        this.lastService.add(new Date());
        this.opinion.add(opinion);
        services++;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public void setDNI(String DNI){
        this.DNI=DNI;
    }
    
    public String getName(){
        return name;
    }
    
    public String getDNI(){
        return DNI;
    }
    
    public int getBirthday(){
        return birthday;
    }
    
    public int getServices(){
        return services;
    }
    
    public boolean equals(Client c){
        return this.name.equals(c.getName()) && DNI.equals(c.getDNI());
    }
}
