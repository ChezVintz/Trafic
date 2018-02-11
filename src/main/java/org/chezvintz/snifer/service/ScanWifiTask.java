package org.chezvintz.snifer.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.chezvintz.snifer.MainModel;
import org.chezvintz.snifer.domain.Antenne;
import org.chezvintz.snifer.domain.Mesure;
import org.chezvintz.snifer.domain.MesureString;
import org.chezvintz.snifer.domain.Piste;
import org.chezvintz.snifer.domain.Position;

public class ScanWifiTask extends TimerTask{
	
	MainModel model;
	List<MesureString> mesures;
	ScanWifi SwF=new ScanWifi();
	
	
	public ScanWifiTask(MainModel model) {
		this.model=model;

	}
	
	
	@Override
	public void run() {
		try {
			mesures=SwF.GetAntenneList();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Piste pistePro = new Piste("Initiale",new Date());
		mesures.forEach(entry->{
			Antenne antennePro;
			Mesure mesurePro;
			
			if (model.getAntenneService().repo.countByMac(entry.getSSB())==0) {
				antennePro=new Antenne(entry.getSSB());		
			} else {
				antennePro=model.getAntenneService().repo.findByMac(entry.getSSB());
			}
			
			
			
			mesurePro=new Mesure(pistePro,model.getPosition(),antennePro,entry.getSignal());
			model.getAntenneService().addAntenne(antennePro);
			model.getPisteService().addPiste(pistePro);
			model.getPositionService().addPosition(model.getPosition());
			
			
			model.getMesureService().addMesure(mesurePro);
			});
	
	
	}
	



	
	


}
