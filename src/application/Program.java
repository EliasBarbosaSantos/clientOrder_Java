package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client date:");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("e-mail: ");
		String clientEmail = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		//Client client = new Client(clientName, clientEmail, birthDate);
		
		System.out.println("Enter order date: ");
		System.out.print("Status: ");
		//OrderStatus status = OrderStatus.valueOf(sc.next());
		
		
		
		Order order = new Order(new Date(), OrderStatus.valueOf(sc.next()), new Client(clientName, clientEmail, birthDate));
				
		System.out.print("How many items to this order? ");
		int items = sc.nextInt();
		
		for (int i = 0; i < items; i++) {
			System.out.println("Enter #" + (1+i) + " item data:");
			System.out.print("Porduct name: ");
			String productName = sc.next();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			Product product = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem(quantity, productPrice, product);	
			
			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println("ORDER SUMARY:");
		System.out.println(order);
		
		
		sc.close();
	}

}
