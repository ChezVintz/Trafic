package org.chezvintz.snifer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="position")
public class Position {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	private Double X;
	private Double Y;
	
	
	public Position(String name, Double x, Double y) {
		super();
		this.name = name;
		this.X = x;
		this.Y = y;
	}

	public Position(Double x, Double y) {
		super();
		this.name = null;
		this.X = x;
		this.Y = y;
	}
	
	public Position() {
		super();
		this.name = null;
		this.X = null;
		this.Y = null;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getX() {
		return X;
	}


	public void setX(Double x) {
		X = x;
	}


	public Double getY() {
		return Y;
	}


	public void setY(Double y) {
		Y = y;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + ", X=" + X + ", Y=" + Y + "]";
	}
	
	
	
	
}
