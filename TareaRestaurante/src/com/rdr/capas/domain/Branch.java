package com.rdr.capas.domain;

import java.sql.Time;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;




@Entity
@Table(schema="public", name="branch")
public class Branch {
	
	@Id
	@GeneratedValue(generator="branch_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "branch_id_seq", sequenceName = "public.branch_id_seq", allocationSize=1)
	private Integer id;

	private String name;

	private String address;
	
	@Basic
	@Column(name = "opening_weekend_time")
	private Time openingWeekendTime;
	
	@Basic
	@Column(name = "closing_weekend_time")
	private Time closingWeekendTime;
	
	@Basic
	@Column(name = "opening_week_time")
	private Time openingWeekTime;
	
	@Basic
	@Column(name = "closing_week_time")
	private Time closingWeekTime;
	
	@Column(name = "number_of_tables")
	private int numberOfTables;
	
	@Column(name = "manager_name")
	private String managerName;
		
	@OneToMany(mappedBy= "branch", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Employee> employees;
	
	public Branch() {		
	}

	public String getAddress() {
		return address;
	}
	
	public Time getClosingWeekendTime() {
		return closingWeekendTime;
	}
	
	public Time getClosingWeekTime() {
		return closingWeekTime;
	}
	
	public Time getOpeningWeekendTime() {
		return openingWeekendTime;
	}
	
	public Time getOpeningWeekTime() {
		return openingWeekTime;
	}
	
	
	public String getManagerName() {
		return managerName;
	}
	
	public int getNumberOfTables() {
		return numberOfTables;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setClosingWeekendTime(Time closingWeekendTime) {
		this.closingWeekendTime = closingWeekendTime;
	}
	
	public void setClosingWeekTime(Time closingWeekTime) {
		this.closingWeekTime = closingWeekTime;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setOpeningWeekendTime(Time openingWeekendTime) {
		this.openingWeekendTime = openingWeekendTime;
	}
	
	public void setOpeningWeekTime(Time openingWeekTime) {	
		this.openingWeekTime = openingWeekTime;
	}
	
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	
	public void setNumberOfTables(int numberOfTables) {
		this.numberOfTables = numberOfTables;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
