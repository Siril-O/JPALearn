package ua.epam.rd.dev.edu.domain;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

@NamedQueries({ @NamedQuery(name = "Order.findAllOrders", query = "SELECT o FROM Order o"),
				@NamedQuery(name = "Order.findOrdersByCustomerId", query = "SELECT o FROM Order o WHERE o.customer.id=:customer")})
@Table(name = "pizza_order")
@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name="total")
	private Double totalSumm;
	private Double discount;

	@ElementCollection
	@CollectionTable(name = "order_item", joinColumns = { @JoinColumn(name = "order_id") })
	@MapKeyJoinColumn(name = "pizza_id")
	@Column(name = "quantity")
	private Map<Pizza, Integer> pizzas;

	public Order() {
		super();
	}

	public Order(Customer customer, Status status, Double totalSumm,
			Double discount, Map<Pizza, Integer> pizzas) {
		super();
		this.customer = customer;
		this.status = status;
		this.totalSumm = totalSumm;
		this.discount = discount;
		this.pizzas = pizzas;
	}

	public Order(Long id, Customer customer, Status status, Double totalSumm,
			Double discount, Map<Pizza, Integer> pizzas) {
		super();
		this.id = id;
		this.customer = customer;
		this.status = status;
		this.totalSumm = totalSumm;
		this.discount = discount;
		this.pizzas = pizzas;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the pizzas
	 */
	@Transactional
	public Map<Pizza, Integer> getPizzas() {
		return pizzas;
	}

	/**
	 * @param pizzas
	 *            the pizzas to set
	 */
	public void setPizzas(Map<Pizza, Integer> pizzas) {
		this.pizzas = pizzas;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the discount
	 */
	public Double getDiscount() {
		return discount;
	}

	/**
	 * @param discount
	 *            the discount to set
	 */
	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	/**
	 * @return the totalSumm
	 */
	public Double getTotalSumm() {
		return totalSumm;
	}

	/**
	 * @param totalSumm
	 *            the totalSumm to set
	 */
	public void setTotalSumm(Double totalSumm) {
		this.totalSumm = totalSumm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", status="
				+ status + ", totalSumm=" + totalSumm + ", discount="
				+ discount + ", pizzas=" + pizzas + "]";
	}

}
