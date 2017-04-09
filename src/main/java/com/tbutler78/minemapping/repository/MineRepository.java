package com.tbutler78.minemapping.repository;

import com.tbutler78.minemapping.domain.Mine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MineRepository extends JpaRepository<Mine, Long> {
	public List<Mine> findByCountyNameAndLatitudeIsNotNullAndLongitudeIsNotNull(String county);
}
