package org.chezvintz.snifer;




import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.chezvintz.snifer.domain.MesureString;
import org.chezvintz.snifer.domain.Order;
import org.chezvintz.snifer.domain.Position;
import org.chezvintz.snifer.domain.Status;
import org.chezvintz.snifer.service.ScanWifi;
import org.chezvintz.snifer.service.ScanWifiTask;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainControler {

	@Autowired
	MainModel model;
	
	Timer timer;
	
	
	// -------Start learning for current position  -----------
	
 
    @RequestMapping(value ="/learn",method=RequestMethod.POST)
    public  ResponseEntity<?> learn(@RequestParam String status, @RequestParam(value ="position", required=false) Long idPosition ) {
    	
    switch (status)
    	  {
    		case "start":	
    		{
    			Position pos = model.getPositionService().repo.findById(idPosition);
    				if (pos == null) {
    				return new ResponseEntity<String>("Position with id " + idPosition  + " not found", HttpStatus.NOT_FOUND);
         }
        model.setPosition(pos);
     	TimerTask task = new ScanWifiTask(model);
		// Subsequent executions take place at approximately regular intervals,
		// separated by the specified period.
     	this.model.setIsRecordig(true);
//    	this.timer=new Timer();	
//    	this.timer.schedule(task, 0, 10000);
		return new ResponseEntity<String>("Enregistrement débuté à : " + new Date(),HttpStatus.OK);
    	  	}
    		case "stop":
    		{
//    			this.timer.cancel();
        	this.model.setIsRecordig(false);
    		return new ResponseEntity<String>("Enregistrement stoppé à : " + new Date(),HttpStatus.OK);	
    		}
    	  }
    return new ResponseEntity<String>("Learn must use 'status=start/stop' and 'position=Id'", HttpStatus.NOT_FOUND);
    }  	
    
    
    
    
    
  // ------------- Stop learning for current position -------  
    
  /*  
    @RequestMapping(value ="/mesure/stop/",method=RequestMethod.POST)
    public @ResponseBody String Stop() {
		
//		this.timer.cancel();
    		this.model.setIsRecordig(false);
		return new String("Enregistrement stoppé à : " + new Date());
}
*/
    
    
    
    
    
    
    @RequestMapping(value ="/api/toLearn",method=RequestMethod.POST)
    public  @ResponseBody Status toLearn(@RequestBody Order order ) {
    	
    	switch(order.getToLearn())
    	{
    	case "start":
    		{
    			Position pos = model.getPositionService().repo.findById(order.getPosition().getId());
    				if (pos == null) { //In this case position doesn't exist in the order object
    				pos=model.getPositionService().repo.findById(model.GetStatus().getPosition().getId()); //We test if current position is set properly 
    				if (pos==null) {//current position doesn't exist
    					this.model.setIsRecordig(false);
    					return model.GetStatus();	
    				}
    			}
        model.setPosition(pos); //From here position exists
        TimerTask task = new ScanWifiTask(model);

     	this.model.setIsRecordig(true);
    	this.timer=new Timer();	
    	this.timer.schedule(task, 0, 10000);
     	return model.GetStatus();	
    		
    	}
    	
    	case "stop":
    	{
			this.timer.cancel();
    	this.model.setIsRecordig(false);
   
		return model.GetStatus();	
    	}
    	
    	}
   
    			return model.GetStatus();
        
}
    
    
    @RequestMapping(value ="/api/setposition",method=RequestMethod.POST)
    public  @ResponseBody Status setPosition(@RequestBody Position position ) {
    	
   
    			Position pos = model.getPositionService().repo.findById(position.getId());
    				if (pos == null) {
    					pos = model.getPositionService().repo.findById(position.getId());
    				}
        model.setPosition(pos);
        return model.GetStatus();	
        
    		}
    
    
    @RequestMapping(value ="/api/positions",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Position> positions() {
    	return model.getPositionService().findAll();
} 
    
    
    @RequestMapping(value ="/api/signals",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<MesureString> signals() {
   
    	ScanWifi SwF=new ScanWifi();
    	List<MesureString> mesures = null;
    
    	try {
			mesures=SwF.GetAntenneList();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    return mesures;	
    
} 
    
    // ---------   Get Status of the app
    
    
  
    @RequestMapping(value ="/api/status",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Status status() {
    	
    	return model.GetStatus();	
} 
    
    
}