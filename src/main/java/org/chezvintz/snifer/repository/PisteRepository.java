package org.chezvintz.snifer.repository;

import org.chezvintz.snifer.domain.Antenne;
import org.chezvintz.snifer.domain.Piste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PisteRepository extends JpaRepository<Piste, Long> {
	
public Piste findById(Long id);



}
