package com.tbutler78.minemapping.service;

import com.tbutler78.minemapping.domain.PropertyFileScan;
import com.tbutler78.minemapping.repository.PropertyFileScanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by butlert on 4/14/17.
 */
@Component
public class PropertyFileScanService {
    private PropertyFileScanRepository propertyFileScanRepository;

    @Autowired
    PropertyFileScanService(PropertyFileScanRepository propertyFileScanRepository){
        this.propertyFileScanRepository = propertyFileScanRepository;
    }

    public List<PropertyFileScan> findAll(){
        return propertyFileScanRepository.findAll();
    }

	public List<PropertyFileScan> findByPropertyNumber(String sequenceNumber) {
    	return propertyFileScanRepository.findByPropertyNumber(sequenceNumber);
	}
}
