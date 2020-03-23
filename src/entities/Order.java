package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private Date moment;
	private OrderStatus staus;
	
	List<OrderItem> items = new ArrayList<>();

	public Order() {
	}

	public Order(Date moment, OrderStatus staus, List<OrderItem> items) {
		this.moment = moment;
		this.staus = staus;
		this.items = items;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStaus() {
		return staus;
	}

	public void setStaus(OrderStatus staus) {
		this.staus = staus;
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
}
