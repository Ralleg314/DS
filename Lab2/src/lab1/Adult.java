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
public class Adult extends Worker{
    public Adult(String name,int age,String address,String city,float wage){
        super(name, age, address, city, wage);
    }
    
    @Override
    public float work(float hour){
        return this.getWage()*hour;
    }
    
}
