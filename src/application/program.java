package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Departament;
import model.entities.Seller;

public class program {
	
	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("Test Seller FindById");
		Seller seller = sellerDao.findById(1);		
		System.out.println(seller);		
		
		
		System.out.println("\nTest Seller FindByDepartament");
		Departament departament  = new Departament(2,null);
		List <Seller> list = sellerDao.findByDepartament(departament);
		for (Seller obj: list) {
		System.out.println(obj);	
		}
		
		System.out.println("\nTest Seller FindAll");
		list = sellerDao.findAll();
		for (Seller obj: list) {
		System.out.println(obj);	
		}
		
		
		
	}

}
