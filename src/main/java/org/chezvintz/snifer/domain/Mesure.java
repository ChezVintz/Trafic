package org.chezvintz.snifer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="mesure")
public class Mesure {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	Double signalLevel;
	
	
	public Mesure() {
		this(null,null,null,null);
	}
	
	public Mesure(Piste piste, Position position, Antenne antenne, Double Level) {
		super();
		this.antenne=antenne;
		this.signalLevel = Level;
		this.position=position;
		this.piste=piste;
	}
	

	@ManyToOne
	@JoinColumn (name="Antenne_ID")
	private Antenne antenne;
	public void setAntenne(Antenne antenne) {this.antenne=antenne;}
	public Antenne getAntenne() {return this.antenne;}
	
	
	@ManyToOne
	@JoinColumn (name="Piste_ID")
	private Piste piste;
	public void setPiste(Piste piste) {this.piste=piste;}
	public Piste getPiste() {return this.piste;}
	
	@ManyToOne
	@JoinColumn (name="Position_ID")
	private Position position;
	public void setPosition(Position position) {this.position=position;}
	public Position getPosition() {return this.position;}
	
	
	public Double getSignalLevel() {
		return signalLevel;
	}
	public void setSignalLevel(Double signal) {
		signalLevel = signal;
	}
	
	
	@Override
	public String toString() {
		return "Mesure [signalLevel=" + signalLevel + ", antenne=" + antenne + "]";
	}
	
}
