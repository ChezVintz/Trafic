package org.chezvintz.snifer.repository;


import org.chezvintz.snifer.domain.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {

	
	public long countById(Long id);
	public Position findById(Long id);
	public Position findByName(String name);
	public boolean existsByName(String name);
	
	
}
