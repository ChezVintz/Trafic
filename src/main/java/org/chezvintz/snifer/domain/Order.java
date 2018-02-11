package org.chezvintz.snifer.domain;

public class Order {

	private String toLearn;
	private Position position;
	
	public Order() {
		super();
		this.toLearn = null;
		this.position = null;
	}
	
	
	public Order(String toLearn, Position position) {
		super();
		this.toLearn = toLearn;
		this.position = position;
	}


	public String getToLearn() {
		return toLearn;
	}


	public void setToLearn(String toLearn) {
		this.toLearn = toLearn;
	}


	public Position getPosition() {
		return position;
	}


	public void setPosition(Position position) {
		this.position = position;
	}
	
	
	
}
