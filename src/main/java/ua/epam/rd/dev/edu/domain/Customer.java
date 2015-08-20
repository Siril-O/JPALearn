package ua.epam.rd.dev.edu.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@NamedQueries({
				@NamedQuery(name="Customer.getAllCustomers",
							query="SELECT c FROM Customer c"),
			    @NamedQuery(name="Customer.getByEmailAndPassword",
			   				query="SELECT c FROM Customer c WHERE c.email=:email AND c.password=:password")})

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "accumulativecard")
	private AccumulativeCard accumulativeCard;
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "address")
	private Address address;
	private String password;
	private String email;
	@Enumerated(EnumType.STRING)
	private Role role;

	public Customer(String name, Address address, String password,
			String email, Role role) {
		super();
		this.name = name;
		this.accumulativeCard = new AccumulativeCard();
		this.address = address;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public Customer(String name, AccumulativeCard accumulativeCard,
			Address address, String password, String email, Role role) {
		super();
		this.name = name;
		this.accumulativeCard = accumulativeCard;
		this.address = address;
		this.password = password;
		this.email = email;
		this.role = role;
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

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", accumulativeCard="
				+ accumulativeCard + ", address=" + address + ", password="
				+ password + ", email=" + email + ", role=" + role + "]";
	}

}
