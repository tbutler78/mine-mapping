package com.tbutler78.minemapping.repository;

import com.tbutler78.minemapping.domain.County;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by butlert on 4/12/17.
 */
@Repository
public interface CountyRepository extends JpaRepository<County, Long>{
    List<County> findAllByName(String name);
    County findOneByName(String name);
}
