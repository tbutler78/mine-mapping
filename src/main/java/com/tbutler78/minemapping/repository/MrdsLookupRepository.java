package com.tbutler78.minemapping.repository;

import com.tbutler78.minemapping.domain.MrdsLookup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by butlert on 4/16/17.
 */


@Repository
public interface MrdsLookupRepository extends JpaRepository<MrdsLookup, Long>{
}
