package com.tbutler78.minemapping.repository;

import com.tbutler78.minemapping.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long>{

	//@Query("select u from User u where u.email=?1 and u.password=?2")
	//User login(String email, String password);

	List<Location> findAll();


}