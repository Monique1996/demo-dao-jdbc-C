package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Department department = new Department(null, null);
				
		System.out.println(" === TEST 1: seller finfById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n === TEST 2: seller finfByDepartment ===");
		department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n === TEST 3: seller finfByAll ===");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n === TEST 4: seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n=== TEST 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n === TEST 6: seller delete ===");
		System.out.println("Enter id of delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		System.out.println("\n ====== DEPARTMENT ======");
		
		DepartmentDao departmentDao = DaoFactory.createDeparmentDao();
	
		System.out.println("\n === TEST 7: department insert ===");
		department = new Department(null, "Clothes");
		departmentDao.insert(department);
		System.out.println("Inserted! New id = " + department.getId());  
		
		System.out.println("\n=== TEST 8: department update ===");
		department = departmentDao.findById(2);
		department.setName("Eletronicos");
		departmentDao.update(department);
		System.out.println("Update completed");
		
		System.out.println("\n === TEST 9: deparment delete ===");
		System.out.println("Enter id of delete test: ");
		departmentDao.deleteById(7);
		System.out.println("Delete completed");
		
		System.out.println("\n === TEST 10: deparment finfByID ===");
		department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println("\n === TEST 11: seller finfByAll ===");
		List<Department> lista = departmentDao.findAll();
		for (Department obj : lista) {
			System.out.println(obj);
		}
		
		sc.close();

	}

}
