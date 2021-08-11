package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.creatteSellerDao();

		System.out.println("-----Teste---Seller-findByid----");
		Seller seller = sellerDao.findByid(3);
		System.out.println(seller);
		System.out.println();
		System.out.println("-----Teste---Seller-FindByDepartment----");
		Department dep = new Department(2, null);

		List<Seller> list = sellerDao.findByDepartment(dep);
		for (Seller obj : list) {

			System.out.println(obj);
		}
		System.out.println("-----Teste---Seller-FindALL----");
		list = sellerDao.findAll();
		for (Seller obj : list) {

			System.out.println(obj);

		}
	}

}
