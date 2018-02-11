package org.chezvintz.snifer.repository;

import org.chezvintz.snifer.domain.Antenne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AntenneRepository extends JpaRepository<Antenne, Long> {
	
public long countByMac(String mac);
public Antenne findById(Long id);

public Antenne findByMac(String mac);

}
