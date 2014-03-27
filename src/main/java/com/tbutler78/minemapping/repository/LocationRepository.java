package com.tbutler78.minemapping.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.tbutler78.minemapping.domain.Location;

@Component
public interface LocationRepository extends JpaRepository<Location, Serializable>{

	//@Query("select u from User u where u.email=?1 and u.password=?2")
	//User login(String email, String password);

	List<Location> findAll();


}