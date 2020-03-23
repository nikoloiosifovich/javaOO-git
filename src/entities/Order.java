package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	List<OrderItem> items = new ArrayList<>();

	public Order() {
	}

	public Order( Date moment, Client client, OrderStatus status ) {
		this.moment = moment;
		this.client = client;
		this.status = status;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment( Date moment ) {
		this.moment = moment;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient( Client client ) {
		this.client = client;
	}

	public OrderStatus getStaus() {
		return status;
	}

	public void setStaus( OrderStatus status ) {
		this.status = status;
	}	
	
	public void addItem( OrderItem item ) {
		items.add( item );
	}
	
	public void removeItem( OrderItem item ) {
		items.remove( item );
	}
	
	public Double total() {
		double sum = 0.0;
		for ( OrderItem i : items ) {
			sum += i.subTotal();
		}
		
		return sum;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append( "ORDER SUMMARY:\n" );
		sb.append( "Order moment: "+ sdf1.format( moment ) +"\n" );
		sb.append( "Order status: "+ status +"\n" );
		sb.append( "Client: "+ client.getName() +" ("+ sdf2.format(client.getBirthDate()) +") - "+ client.getEmail() +"\n" );
		sb.append( "Order items\n");
		items.forEach( e -> sb.append(
				e.getProduct().getName() +", $"+ e.getProduct().getPrice() +", Quantity: "+ e.getQuantity() +", Subtotal: $"+ e.subTotal() +"\n"
		));
		sb.append( "Total price: $"+ this.total() );
		
		return sb.toString();
	}
	
}
