package application;


import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program_Seller {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.creatteSellerDao();

		System.out.println("-----Teste1---Seller-findByid----");
		Seller seller = sellerDao.findByid(3);
		System.out.println(seller);
		System.out.println();
		System.out.println("-----Teste2---Seller-FindByDepartment----");
		Department dep = new Department(2, null);

		List<Seller> list = sellerDao.findByDepartment(dep);
		for (Seller obj : list) {

			System.out.println(obj);
		}
		System.out.println("-----Teste3---Seller-FindALL-order name---");
		list = sellerDao.findAll();
		for (Seller obj : list) {

			System.out.println(obj);
		
		}
		System.out.println("\n=== Teste4 seller insert =====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(0), 4000.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId()); 
		
		System.out.println("-----Teste 5---Seller-update---");
		
		seller = sellerDao.findByid(1); // BUSCA O ID P/ alteração
		seller.setName("ABIM DA ROCHA");
		seller.setEmail("abim@gmail.com");
		sellerDao.update(seller);
		System.out.println("Atualizado");
		
		System.out.println("-----Teste---Seller-DELETE---");
		System.out.print("Digite id que deseja delatar: " );
		int id = sc.nextInt();
		
		sellerDao.deleteById(id);
		
		
		sc.close();
	}

}
