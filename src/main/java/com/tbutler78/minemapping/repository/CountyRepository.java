package com.tbutler78.minemapping.repository;

import com.tbutler78.minemapping.domain.County;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by butlert on 4/12/17.
 */
public interface CountyRepository extends JpaRepository<County, Integer>{
    List<County> findAllByName(String name);
}
