package com.example.foodTownEntities.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private Long mobilenumber;
	//@Column(nullable = false)
	//private Date regdate;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int id, String name, String username, String password, String email, Long mobilenumber) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobilenumber = mobilenumber;
		//this.regdate = regdate;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(Long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	/*public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	*/
}
