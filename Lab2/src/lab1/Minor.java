/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author abergaye8.alumnes
 */
public class Minor extends Worker{
    private String tutor;
    
    public Minor(String name,int age,String address,String city,float wage,String tutor){
        super(name, age, address, city, wage);
        this.tutor=tutor;
    }
    
    public void setTutor(String tutor){
        this.tutor=tutor;
    }
    
    @Override
    public float work(float hour){
        return this.getWage()*hour;
    }
}


