package com.tbutler78.minemapping.repository;

import com.tbutler78.minemapping.domain.Reference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by butlert on 4/17/17.
 */

@Repository
public interface ReferenceRepository extends JpaRepository<Reference, Long> {
	List<Reference> findByReferenceId(String referenceId);
}
