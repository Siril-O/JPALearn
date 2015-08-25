package ua.epam.rd.dev.edu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccumulativeCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@OneToOne(mappedBy = "accumulativeCard")
//	private Customer customer;

	@Column(name = "summ")
	private Double totalSumm;

	// private Address address;

	public AccumulativeCard() {
		super();
		totalSumm = 0d;
	}

	public AccumulativeCard(Double totalSumm) {
		super();
		this.totalSumm = totalSumm;
	}

//	public AccumulativeCard(Customer customer, Double totalSumm) {
//		super();
//		this.customer = customer;
//		this.totalSumm = totalSumm;
//	}

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
		return "AccumulativeCard [id=" + id + ", totalSumm=" + totalSumm + "]";
	}

	/*	*//**
	 * @return the customer
	 */
	/*
	 * public Customer getCustomer() { return customer; }
	 *//**
	 * @param customer
	 *            the customer to set
	 */
	/*
	 * public void setCustomer(Customer customer) { this.customer = customer; }
	 */

}
