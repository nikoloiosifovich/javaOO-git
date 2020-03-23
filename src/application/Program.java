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

		Scanner sc = new Scanner( System.in );
		sc.useLocale( Locale.US );
		
		SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
		Date moment = new Date();
		
		System.out.println( "Enter cliente data:" );
		System.out.print( "Name: " );
		String name = sc.next();
		System.out.print( "Email: " );
		String email = sc.next();
		System.out.print( "Birth date (DD/MM/YYYY): " );
		Date birthDay = sdf.parse( sc.next() );
		
		Client client = new Client(name, email, birthDay);
		
		System.out.println( "Enter order data:" );
		System.out.print( "Status: " );
		String status = sc.next();
		
		Order order = new Order( moment, client, OrderStatus.valueOf( status ) );
		
		System.out.print( "How many items to this order? " );
		int numItems = sc.nextInt();
		
		for ( int i=0; i<numItems; i++ ) {
			System.out.println( "Enter #"+ (i+1) +"item data:" );
			System.out.print( "Product name: " );
			String productName = sc.next();
			System.out.print( "Product price: " );
			double productPrice = sc.nextDouble();
			System.out.print( "Quantity: " );
			int quantity = sc.nextInt();
			
			Product product = new Product( productName, productPrice );
			OrderItem orderItems = new OrderItem( quantity, product );
			order.addItem(orderItems);
		}
		
		System.out.println( order );
		
		sc.close();
		
	}
}
