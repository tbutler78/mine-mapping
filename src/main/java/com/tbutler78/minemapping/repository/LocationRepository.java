package com.tbutler78.minemapping.repository;

import com.tbutler78.minemapping.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public interface LocationRepository extends JpaRepository<Location, Serializable>{

	//@Query("select u from User u where u.email=?1 and u.password=?2")
	//User login(String email, String password);

	List<Location> findAll();


}
