package entities;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entities.enums.OrderStauts;

public class Order {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStauts status;
	
	private Client cliente;
	private List<OrderItem> items = new ArrayList<OrderItem>();
	
	
	public Order() {
		
	}


	public Order(Date moment, OrderStauts status, Client cliente) {
		this.moment = moment;
		this.status = status;
		this.cliente = cliente;
	}


	public Date getMoment() {
		return moment;
	}


	public void setMoment(Date moment) {
		this.moment = moment;
	}


	public OrderStauts getStatus() {
		return status;
	}


	public void setStatus(OrderStauts status) {
		this.status = status;
	}


	public Client getCliente() {
		return cliente;
	}


	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
		
	}
	
	public double total() {
		double sum = 0.0;
		// for each
		for (OrderItem it : items) {
			sum += it.subTotal();
		}
		return sum;
				
	}
	
	public String tostrint() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order Status: ");
		sb.append(status + "\n");
		sb.append("Cliente : ");
		sb.append(cliente + "\n");
		sb.append("Order items: \n");
		for (OrderItem item : items) {
			sb.append(item + "\n");
			
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f" + total()));
		
		return sb.toString();
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
}
