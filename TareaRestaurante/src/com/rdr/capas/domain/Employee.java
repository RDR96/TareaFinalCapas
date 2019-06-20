package com.rdr.capas.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema="public", name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(generator="user_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "user_id_seq", sequenceName = "public.user_id_seq", allocationSize=1)
	private Integer id;

	private String name; 

	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
	
	private String genre;
	
	private boolean status;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "branch_id", nullable= false)
	private Branch branch;
		
	
	//@Column(name = "branch_id")
	//private Integer branchId;
	
	/*@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id", insertable=false, updatable=false)
	private Branch branch;*/
		
	
	public Employee() {
		
	}
	
	
	public Date getBirth() {
		
		return birth;
	}
	
	/*public Branch getBranch() {
		return branch;
	}*/
	
	public String getGenre() {
		return genre;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	/*public void setBranch(Branch branch) {
		this.branch = branch;
	}*/
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	public String getDelegateStatus() {
		if (status) {
			return "Disponible";
		}
		else {
			return "No disponible";
		}
	}

	
	
	public Branch getBranch() {
		return branch;
	}
	
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public long getAge() {		
	    
	 
	    long diffInMillies = Math.abs(new Date().getTime() - birth.getTime() );
	    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
	    return diff;
	
	}
	
	
	public int getBranchMasterId () {
		
		return this.branch.getId();	
	}
	
	public void setBranchMasterId (int id) {
		this.branch.setId(id);
	}
	
}