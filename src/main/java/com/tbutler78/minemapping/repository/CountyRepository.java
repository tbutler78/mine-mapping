package com.tbutler78.minemapping.repository;

import com.tbutler78.minemapping.domain.County;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by butlert on 4/12/17.
 */
@Component
public interface CountyRepository extends JpaRepository<County, Integer>{
    List<County> findAllByName(String name);
}
