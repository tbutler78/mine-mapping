package com.tbutler78.minemapping.repository;

import com.tbutler78.minemapping.domain.ReferenceRelate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReferenceRelateRepository extends JpaRepository<ReferenceRelate, Long>{
    List<ReferenceRelate> findAllBySequenceNumber(String sequenceNumber);

    List<ReferenceRelate> findAllByRefId(String refId);

    ReferenceRelate findOneBySequenceNumber(String sequenceNumber);
}
