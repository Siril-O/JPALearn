package ua.epam.rd.dev.edu.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double price;
	@Enumerated(EnumType.STRING)
	private PizzaType type;

	public Pizza() {
		super();
	}

	public Pizza(String name, Double price, PizzaType type) {
		super();
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public Pizza(Long id, String name, Double price, PizzaType type) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the type
	 */
	public PizzaType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(PizzaType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", name=" + name + ", price=" + price
				+ ", type=" + type + "]";
	}

}
