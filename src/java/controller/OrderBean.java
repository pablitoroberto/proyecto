package controller;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Arrays;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
@ManagedBean(name="order")
@SessionScoped
public class OrderBean implements Serializable{

	private static final long serialVersionUID = 1L;

	String dia;
	String Hora_inicio;
	String Hora_fin;
	
	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHora_inicio() {
		return Hora_inicio;
	}

	public void setHora_inicio(String Hora_inicio) {
		this.Hora_inicio = Hora_inicio;
	}

	public String getHora_fin() {
		return Hora_fin;
	}

	public void setHora_fin(String Hora_fin) {
		this.Hora_fin = Hora_fin;
	}

	

	private static final ArrayList<Order> orderList = 
		new ArrayList<Order>(Arrays.asList(
		
		
	));
	 
	public ArrayList<Order> getOrderList() {
 
		return orderList;
 
	}
	
	public String addAction() {
	    
		Order order = new Order(this.dia, this.Hora_inicio, 
			this.Hora_fin );
		
		orderList.add(order);
		
		return null;
	}
 
	public String deleteAction(Order order) {
	    
		orderList.remove(order);
		return null;
	}

	public static class Order{
		
		String dia;
		String Hora_inicio;
		String Hora_fin;
		

		public Order(String orderNo, String productName, 
				String price) {
			this.dia = orderNo;
			this.Hora_inicio = productName;
			this.Hora_fin = price;
			
		}
		
		public String getDia() {
			return dia;
		}
		public void setDia(String dia) {
			this.dia = dia;
		}
		public String getHora_inicio() {
			return Hora_inicio;
		}
		public void setHora_inicio(String Hora_inicio) {
			this.Hora_inicio = Hora_inicio;
		}
		public String getHora_fin() {
			return Hora_fin;
		}
		public void setHora_fin(String Hora_fin) {
			this.Hora_fin = Hora_fin;
		}
		
	}
}