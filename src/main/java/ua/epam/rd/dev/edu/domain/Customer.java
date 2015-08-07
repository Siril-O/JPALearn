package ua.epam.rd.dev.edu.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "accumulativecard")
	private AccumulativeCard accumulativeCard;
	@OneToOne(cascade = {CascadeType.ALL} )
	@JoinColumn(name = "address")
	private Address address;

	public Customer(String name, AccumulativeCard accumulativeCard,
			Address address) {
		super();
		this.name = name;
		this.accumulativeCard = accumulativeCard;
		this.address = address;
	}

	public Customer() {
		super();
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
	 * @return the accumulativeCard
	 */
	public AccumulativeCard getAccumulativeCard() {
		return accumulativeCard;
	}

	/**
	 * @param accumulativeCard
	 *            the accumulativeCard to set
	 */
	public void setAccumulativeCard(AccumulativeCard accumulativeCard) {
		this.accumulativeCard = accumulativeCard;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", accumulativeCard="
				+ accumulativeCard + ", address=" + address + "]";
	}

}
