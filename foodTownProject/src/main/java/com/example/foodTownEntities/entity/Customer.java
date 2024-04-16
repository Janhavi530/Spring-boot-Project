package com.example.foodTownEntities.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;
	    
	    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	    private List<Order> orders;
	    
	    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	    private List<Order> feedback;
	    
	    @Column(nullable = false)
	    private String name;
	    
	    @Column(nullable = false)
	    private String email;
	    
	    @Column(nullable = false)
	    private String address;
	    
	    @Column(nullable = false)
	    private long phno;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String email, String address, long phno) {
		super();
	
		this.name = name;
		this.email = email;
		this.address = address;
		this.phno = phno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}
	
	
}
