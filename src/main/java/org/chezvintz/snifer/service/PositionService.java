package org.chezvintz.snifer.service;

import java.util.List;

import org.chezvintz.snifer.domain.Position;
import org.chezvintz.snifer.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService {

@Autowired
public PositionRepository repo;

public PositionService() {
	
}



public List<Position> findAll(){
	return repo.findAll();
}
	
public void addPosition(Position position) {
	repo.save(position);
}	



}
