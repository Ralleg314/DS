package lab1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abergaye8.alumnes
 */
public class Worker {
    private String name;
    private int age;
    private String address;
    private String city;
    private float wage;
    private int services;
    
    public Worker(String name){
        this.name=name;
        this.age=-1;
        this.address="";
        this.city="";
        this.wage=-1;
        services=-1;
    }
    
    public Worker(String name,int age,String address,String city,float wage){
        this.name=name;
        this.age=age;
        this.address=address;
        this.city=city;
        this.wage=wage;
        services=0;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setAge(int age){
        this.age=age;
    }
    
    public void setAddress(String address){
        this.address=address;
    }
    
    public void setCity(String city){
        this.city=city;
    }
    
    public void setWage(float wage){
        this.wage=wage;
    }
    
    public float getWage(){
        return wage;
    }
    
    public int getServices(){
        return services;
    }
    
    public boolean equals(Worker w){
        return this.name.equals(w.getName());
    }
    
    public void newService(){
        services++;
    }
    
    public float work(float hour){
        return 0;
    };
}
