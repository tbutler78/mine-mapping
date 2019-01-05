package com.tbutler78.minemapping.service;

import com.tbutler78.minemapping.domain.MrdsLookup;
import com.tbutler78.minemapping.repository.MrdsLookupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by butlert on 4/16/17.
 */
@Service
public class MrdsService {

    private final MrdsLookupRepository mrdsLookupRepository;
    @Autowired
    public MrdsService(MrdsLookupRepository mrdsLookupRepository) {
        this.mrdsLookupRepository = mrdsLookupRepository;
    }

    public List<MrdsLookup> getAll(){
        return mrdsLookupRepository.findAll();
    }

}
