package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Departament;
import model.entities.Seller;

public class program {
	
	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("\nTest Seller FindByDepartament");
		Departament departament  = new Departament(2,null);
		List <Seller> list = sellerDao.findByDepartament(departament);
		for (Seller obj: list) {
		System.out.println(obj);	
		}
		
		System.out.println("\nTest Seller Insert");
		Seller newSeller = new Seller (1,"Ronaldo","test@tes.com.br",new Date(),5000.,departament);
		sellerDao.insert(newSeller);
		System.out.println("Inserted New Id = " + newSeller.getId());
		
		
		System.out.println("Test Seller FindById");
		Seller seller = sellerDao.findById(1);		
		System.out.println(seller);		
		
				
		System.out.println("\nTest Seller FindAll");
		list = sellerDao.findAll();
		for (Seller obj: list) {
		System.out.println(obj);	
		}
			
	}

}
