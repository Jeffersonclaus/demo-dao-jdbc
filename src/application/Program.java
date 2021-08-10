package application;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

public static void main(String[] args) {
	
	
	Department obj = new Department(1, "book");
	Seller seller = new Seller(21,"bobo", "bobo@gamil.com", new Date(),2000.00, obj );
	System.out.println(obj);

	System.out.println(seller);
}

	
}
