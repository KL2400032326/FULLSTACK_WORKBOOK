package com.klu.model;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Scanner;
public class Main {
public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choice;
		do {
			System.out.println("====== Product CRUD MENU ======");
			System.out.println("1. Add Product");
			System.out.println("2. View Product");
			System.out.println("3. Update Product");
			System.out.println("4. Delete Product");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
		 choice=sc.nextInt();
		 switch(choice) {
		 case 1: AddProduct(sc); break;
		 case 2: ViewProduct(sc); break;
		 case 3: UpdateProduct(sc); break;
		 case 4: DeleteProduct(sc); break;
		 case 5: System.out.println("Thank You!"); break;
		 default: System.out.println("Sorry Enter correct choice"); 
		 }
		}while(choice!=5);
		

	}

private static void DeleteProduct(Scanner sc) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx4 = session.beginTransaction();

	System.out.print("Enter Student ID to Delete: ");
	int did = sc.nextInt();

	Product dst = session.get(Product.class, did); // Persistent
	if (dst != null) {
	session.delete(dst);
	tx4.commit();
	System.out.println("Product Deleted Successfully");
	} else {
	System.out.println("Product Not Found");
	tx4.rollback();
	}
	session.close();
	
}

private static void UpdateProduct(Scanner sc) {
	Session session=HibernateUtil.getSessionFactory().openSession();
	Transaction tx1 = session.beginTransaction();
	System.out.print("Enter Product ID: ");
	int id = sc.nextInt();

	Product st = session.get(Product.class, id);
	if (st != null) {
		sc.nextLine();
		System.out.print("Enter New Name: ");
		st.setQuantity(sc.nextInt());
		System.out.print("Enter New Marks: ");
		st.setPrice(sc.nextInt());

		// No update() needed
		tx1.commit();
		System.out.println("Student Updated Successfully");
		} else {
		System.out.println("Student Not Found");
		tx1.rollback();
		}
		session.close();
	}
	
	
	


private static void ViewProduct(Scanner sc) {
	Session session=HibernateUtil.getSessionFactory().openSession();
	System.out.print("Enter Product ID: ");
	int id = sc.nextInt();

	Product st = session.get(Product.class, id);
	if (st != null) {
	System.out.println("ID: " + st.getId());
	System.out.println("Name: " + st.getName());
	System.out.println("Description: " + st.getDes());
	System.out.println("Price: " + st.getPrice());
	System.out.println("Quantity: " + st.getQuantity());
	} else {
	System.out.println("Product Not Found");
	}
	session.close();
	
}

private static void AddProduct(Scanner sc) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();

    Product p = new Product();

    System.out.print("Enter ID: ");
    p.setId(sc.nextInt());
    sc.nextLine(); // 🔥 consume newline

    System.out.print("Enter Name: ");
    p.setName(sc.nextLine());

    System.out.print("Enter Description: ");
    p.setDes(sc.nextLine());

    System.out.print("Enter Price: ");
    p.setPrice(sc.nextDouble());

    System.out.print("Enter Quantity: ");
    p.setQuantity(sc.nextInt());

    session.save(p);
    tx.commit();
    session.close();

    System.out.println("Product Added Successfully");
}

}
