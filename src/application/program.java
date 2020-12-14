package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class program {
	
	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("Test Seller FindById");
		Seller seller = sellerDao.findById(1);		
		System.out.println(seller);		
		
	}

}
