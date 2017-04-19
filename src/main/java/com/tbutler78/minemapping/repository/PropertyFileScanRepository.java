package com.tbutler78.minemapping.repository;

import com.tbutler78.minemapping.domain.PropertyFileScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by butlert on 4/14/17.
 */

@Repository
public interface PropertyFileScanRepository extends JpaRepository<PropertyFileScan, Long> {
    List<PropertyFileScan> findByPropertyNumber(String propertyNumber);

}
