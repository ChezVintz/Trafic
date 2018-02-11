package org.chezvintz.snifer;

import java.util.Date;

import org.chezvintz.snifer.domain.Position;
import org.chezvintz.snifer.service.AntenneService;
import org.chezvintz.snifer.service.MesureService;
import org.chezvintz.snifer.service.PisteService;
import org.chezvintz.snifer.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.chezvintz.snifer.domain.Status;

@Component
public class MainModel {
	

	private Status status;
	
	@Autowired
	private AntenneService antenneService;
	@Autowired
	private MesureService mesureService;
	@Autowired
	private PositionService positionService;
	@Autowired
	private PisteService pisteService;
	
	
	public MainModel() {
		super();
		this.status = new Status(new Position("Inconnue",0.0,0.0),false); 

	} 

	
	
	
	
	public Position getPosition() {
		return status.getPosition();
	}
	public void setPosition(Position position) {
		this.status.setPosition(position);
	}
	public Boolean getIsRecordig() {
		return this.status.getIsRecording();
	}
	public void setIsRecordig(Boolean isRecording) {
		this.status.setIsRecording(isRecording);
		if (!isRecording) {status.setStartRecord(null);} else {status.setStartRecord(new Date()); }
	}


	public AntenneService getAntenneService() {
		return antenneService;
	}

	public void setAntenneService(AntenneService antenneService) {
		this.antenneService = antenneService;
	}

	public MesureService getMesureService() {
		return mesureService;
	}

	public void setMesureService(MesureService mesureService) {
		this.mesureService = mesureService;
	}

	public PositionService getPositionService() {
		return positionService;
	}

	public void setPositionService(PositionService positionService) {
		this.positionService = positionService;
	}

	public PisteService getPisteService() {
		return pisteService;
	}

	public void setPisteService(PisteService pisteService) {
		this.pisteService = pisteService;
	}





public Status GetStatus() {
	return this.status;
	
}


	
	
}
