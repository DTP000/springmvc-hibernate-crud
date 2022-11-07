package tk.dtp000.springmvcandhibernate.crudtwotable.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;

	@Column(name="tel")
	private String tel;

	@Column(name="address")
	private String address;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="birthyear")
	private int birthYear;
	
	@ManyToOne
    @JoinColumn(name="company_id")
	private Company company;
}
