package com.tbutler78.minemapping.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.tbutler78.minemapping.domain.Mine;

@Component
public interface MineRepository extends JpaRepository<Mine, Long> {
	public List<Mine> findByCountyNameAndLatitudeIsNotNullAndLongitudeIsNotNull(String county);
}
