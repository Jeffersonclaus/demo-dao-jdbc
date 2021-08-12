package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program_Department {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("-----Teste1---Department-findByid----");
		DepartmentDao depDao = DaoFactory.creatteDepartmentDao();
		System.out.print("Bucar id: ");
		int idfind = sc.nextInt();
		Department dep = depDao.findByid(idfind);  
		System.out.println(dep);
		System.out.println("-----Teste2---Department-findAll----");
		List<Department> list = new ArrayList<>();
		
		list = depDao.findAll();
		for (Department dep1 : list) {
			System.out.println(dep1);
		}
		System.out.println("-----Teste3---Department-Update----");	
		
		System.out.print("Digite ID p/ update: ");
		int idUp = sc.nextInt();
		DepartmentDao depdao1 = DaoFactory.creatteDepartmentDao();
		System.out.print("Digite nome: ");
		sc.nextLine();
		String  nomeNovo = sc.nextLine();
		Department dep1 = depdao1.findByid(idUp);	
		dep1.setName(nomeNovo);
		depdao1.update(dep1);
		
		System.out.println("-----Teste4---Department-Insert----");	
		System.out.print("Digite nome department: ");	
		String nomeDpartmen =  sc.nextLine();
		Department dep3 = new Department(null, nomeDpartmen);
		depdao1.insert(dep3);
		System.out.println("Criado!" + dep3.getId());
		
		
		
		
					
		System.out.println("-----Teste---Department-Delete----");
		System.out.print("Digite id Department p/ deletar: ");
		int iddelete = sc.nextInt();
		depDao.deleteById(iddelete);
		
		sc.close();
	}

}
