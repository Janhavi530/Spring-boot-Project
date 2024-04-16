package com.example.foodTownEntities.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, length = 100)
	private String pay_mode;
	@Column(nullable = false, length = 100)
	private long total;
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(int id, String pay_mode, long total) {
		super();
		this.id = id;
		this.pay_mode = pay_mode;
		this.total = total;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPay_mode() {
		return pay_mode;
	}
	public void setPay_mode(String pay_mode) {
		this.pay_mode = pay_mode;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	
	
}
