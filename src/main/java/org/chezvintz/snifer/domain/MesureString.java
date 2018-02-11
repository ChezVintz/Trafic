package org.chezvintz.snifer.domain;

public class MesureString {

	private String SSB;
	private Double Signal;
	
	
	public MesureString(String sSB, Double signal) {
		super();
		SSB = sSB;
		Signal = signal;
	}


	@Override
	public String toString() {
		return "MesureString [SSB=" + SSB + ", Signal=" + Signal.toString() + "]";
	}


	public String getSSB() {
		return SSB;
	}


	public void setSSB(String sSB) {
		SSB = sSB;
	}


	public Double getSignal() {
		return Signal;
	}


	public void setSignal(Double signal) {
		Signal = signal;
	}
	
	
	
	
	
	
}
