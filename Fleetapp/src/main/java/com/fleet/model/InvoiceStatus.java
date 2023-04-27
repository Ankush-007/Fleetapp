package com.fleet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="id")
public class InvoiceStatus extends CommonObjects {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String paid;
	private String overdue;
	
	
	
	public InvoiceStatus(Integer id, String description, String details) {
		super(id, description, details);
	}



	public InvoiceStatus(Integer id, String description, String details, Integer id2, String paid, String overdue) {
		super(id, description, details);
		id = id2;
		this.paid = paid;
		this.overdue = overdue;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getPaid() {
		return paid;
	}



	public void setPaid(String paid) {
		this.paid = paid;
	}



	public String getOverdue() {
		return overdue;
	}



	public void setOverdue(String overdue) {
		this.overdue = overdue;
	}
	
	
}
