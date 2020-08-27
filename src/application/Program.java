package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStauts;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		/*
		Product p = new Product("TV", 1000.00);
		OrderItem oi1 = new OrderItem(1, 1000.0, p);
		Client cli = new Client("Marcos", "marcos@gmail.com", sdf.parse("12/12/1963"));
		System.out.println(oi1.getProduct().getName());
		System.out.println(oi1.getQuantity());
		System.out.println(oi1);
		System.out.println(cli);
		*/
		
		System.out.println("Enter client data:");
		
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.next();
		
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		// Instanciei o cliente 
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data:");
		
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		// Instanciei o Order
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		for (int i=1; i<=n; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();

			// Instanciei o Produto
			Product product = new Product(productName, productPrice);

			System.out.print("Quantity: ");
			int quantity = sc.nextInt();

			OrderItem orderItem = new OrderItem(quantity, productPrice, product); 

			order.addItem(orderItem);
		}
		
		sc.close();
		
	}

}
