package org.chezvintz.snifer.service;

import java.util.List;

import org.chezvintz.snifer.domain.Antenne;
import org.chezvintz.snifer.repository.AntenneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.repository.Repository;

@Service
public class AntenneService {

@Autowired 
AntenneRepository repo;

public AntenneService() {
	
}

public List<Antenne> findAll(){
	return repo.findAll();
}

public void addAntenne(Antenne antenne) {
	repo.save(antenne);
}


	
}
