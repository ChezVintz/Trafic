package org.chezvintz.snifer.service;

import java.util.List;

import org.chezvintz.snifer.domain.Piste;
import org.chezvintz.snifer.repository.PisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PisteService {

@Autowired 
PisteRepository repo;

public PisteService() {
	
}

public List<Piste> findAll(){
	return repo.findAll();
}

public void addPiste(Piste piste) {
	repo.save(piste);
}


	
}
