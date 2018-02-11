package org.chezvintz.snifer.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
import org.chezvintz.snifer.domain.MesureString;

public class ScanWifi {
	
	
	
public ScanWifi() {
	
}

public List<MesureString> GetAntenneList() throws InterruptedException, IOException {
	
	
	Pattern mac = Pattern.compile("([\\w]{2}[\\:]){5}[\\w]{2}");
	Pattern signal = Pattern.compile("signal: (.*) dBm");
	String outPut =new String();
	
	ProcessBuilder pb = new ProcessBuilder("sudo","iw","dev","wlan0","scan");
	Process process = pb.start();
	int errCode = process.waitFor();
	System.out.println("Echo command executed, any errors? " + (errCode == 0 ? "No" : "Yes"));
	
	if (errCode==0){

		outPut =  IOUtils.toString(process.getInputStream(), "UTF-8");
		Matcher macMatcher = mac.matcher(outPut);
		Matcher signalMatcher = signal.matcher(outPut);
		List<MesureString> mesures=new ArrayList<MesureString>();
		MesureString mesure;
		
		while(macMatcher.find() && signalMatcher.find()) {
            mesure=new MesureString(macMatcher.group().toString(),Double.parseDouble(signalMatcher.group(1)));
            mesures.add(mesure);   
        }	
	return mesures;
	}
	return null;	
}


}
	

