package tk.dtp000.springmvcandhibernate.crudtwotable.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	public Company() {
		super();
	}

	public Company(int id, String name, String address, String tel, String taxNo, String email, String description) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.taxNo = taxNo;
		this.email = email;
		this.description = description;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTaxNo() {
		return taxNo;
	}

	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="address")
	private String address;

	@Column(name="tel")
	private String tel;

	@Column(name="taxNo")
	private String taxNo;
	
	@Column(name="email")
	private String email;
	
	@Column(name="description")
	private String description;
	
//	@OneToMany
////	@JoinColumn(name = "TEACHER_ID", referencedColumnName = "ID")
//	private List<Employee> employee;
}
