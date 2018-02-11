package org.chezvintz.snifer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="antenne")
public class Antenne {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String mac;
	
	public Antenne(String mac) {
		this.mac=mac;
	}
	
	public Antenne(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	

	public String toString() {
		return "SniferAntenne [id=" + id + ", mac=" + mac + "]";
	}
	

	
	
	
}
