package com.tbutler78.minemapping.repository;

import com.tbutler78.minemapping.domain.MrdsLookup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Created by butlert on 4/16/17.
 */


@Component
public interface MrdsLookupRepository extends JpaRepository<MrdsLookup, Long>{
}
