package Encapsulation;

public class TestEncapsulation {
	public static void main (String[] args)  
    { 
        Encapsulate obj = new Encapsulate(); 
        obj.setName("Varun"); 
        obj.setAge(18); 
        obj.setRoll(24); 
        System.out.println("My name: " + obj.getName()); 
        System.out.println("My age: " + obj.getAge()); 
        System.out.println("My roll: " + obj.getRoll());      
    } 


}
