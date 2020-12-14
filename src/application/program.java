package application;

import java.util.Date;

import model.entities.Departament;
import model.entities.Seller;

public class program {
	
	public static void main(String[] args) {
		
		Departament obj = new Departament (1,"books");
		
		System.out.println(obj);		
		
		Seller obj1 = new Seller(1,"Ronaldo","ronaldo@Eu.com", new Date(), 2222.0, obj);
		
		System.out.println(obj1);		
	}

}
