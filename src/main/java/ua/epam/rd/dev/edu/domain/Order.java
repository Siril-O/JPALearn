package ua.epam.rd.dev.edu.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


public class Order {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
//	private List<Pizza> pizzas;
	@ManyToOne
	@JoinColumn 
	private Customer customer;

	public Order(Customer customer, List<Pizza> pizzas) {
//		this.pizzas = pizzas;
		this.customer = customer;
	}

	public Order() {
		super();
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Order [id=" + id  + ", customer="
				+ customer + "]";
	}

	public void destroy() {
		System.out.println("Destroy");
	}
}
