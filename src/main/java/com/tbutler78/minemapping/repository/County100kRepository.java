package com.tbutler78.minemapping.repository;

import com.tbutler78.minemapping.domain.County100k;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by butlert on 4/21/17.
 */
@Repository
public interface County100kRepository extends JpaRepository<County100k, Long> {
}
