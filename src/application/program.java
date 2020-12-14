package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Departament;
import model.entities.Seller;

public class program {
	
	public static void main(String[] args) {
		
		Departament obj = new Departament (1,"books");
		
		System.out.println(obj);		
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Seller seller = sellerDao.findById(1);
		
		
		
		System.out.println(seller);		
		
	}

}
