package org.chezvintz.snifer.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="piste")
public class Piste {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	public Piste(String name, Date date) {
		super();
		this.name = name;
		this.date = date;
	}
	public Piste(Date date) {
		super();
		this.name = null;
		this.date = date;
	}
	public Piste() {
		super();
		this.name = null;
		this.date = null;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
