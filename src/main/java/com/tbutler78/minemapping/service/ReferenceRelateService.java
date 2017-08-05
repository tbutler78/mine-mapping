package com.tbutler78.minemapping.service;

import com.tbutler78.minemapping.domain.ReferenceRelate;
import com.tbutler78.minemapping.repository.ReferenceRelateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReferenceRelateService {


    private final ReferenceRelateRepository referenceRelateRepository;

    @Autowired
    public ReferenceRelateService(ReferenceRelateRepository referenceRelateRepository){
        this.referenceRelateRepository = referenceRelateRepository;
    }

    public List<ReferenceRelate> getAll(){
        return referenceRelateRepository.findAll();
    }

    public List<ReferenceRelate> findBySequenceNumber(String sequenceNumber){
        return referenceRelateRepository.findAllBySequenceNumber(sequenceNumber);
    }

    public List<ReferenceRelate> findByRefId(String refId){
        return referenceRelateRepository.findAllByRefId(refId);
    }

    public ReferenceRelate findOneBySequenceNumber(String sequenceNumber) {
        return referenceRelateRepository.findOneBySequenceNumber(sequenceNumber);
    }
}
