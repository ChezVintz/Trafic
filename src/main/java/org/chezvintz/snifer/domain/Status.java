package org.chezvintz.snifer.domain;

import java.util.Date;

public class Status {

	
	private Position position;
	private Boolean isRecording;
	private Date startRecord;
	
	
	public Status(Position position, Boolean isRecording) {
		super();
		this.position = position;
		this.isRecording = isRecording;
	}
	
	public Status(Position position, Boolean isRecording, Date startRecord) {
		super();
		this.position = position;
		this.isRecording = isRecording;
		this.startRecord=startRecord;
	}
	
	public Date getStartRecord() {
		return startRecord;
	}
	public void setStartRecord(Date startRecord) {
		this.startRecord = startRecord;
	}
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Boolean getIsRecording() {
		return isRecording;
	}
	public void setIsRecording(Boolean isRecording) {
		this.isRecording = isRecording;
	}
	
	@Override
	public String toString() {
		return "Status [position=" + position + ", isRecording=" + isRecording + "]";
	}

}
