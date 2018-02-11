package org.chezvintz.snifer.service;

import java.util.List;

import org.chezvintz.snifer.domain.Mesure;
import org.chezvintz.snifer.repository.MesureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesureService {

@Autowired 
MesureRepository repo;

public MesureService() {
	
}



public List<Mesure> findAll(){
	return repo.findAll();
}
	
public void addMesure(Mesure mesure) {
	repo.save(mesure);
}	




}
