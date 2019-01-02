package com.tbutler78.minemapping.service;

import com.tbutler78.minemapping.domain.County;
import com.tbutler78.minemapping.repository.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by butlert on 4/13/17.
 */
@Component
public class CountyService {
    private final CountyRepository countyRepository;

    @Autowired
    public CountyService(CountyRepository countyRepository) {
        this.countyRepository = countyRepository;
    }

    public County findOneByName(String name){
      return countyRepository.findOneByName(name);
    }

    public List<County> getCounties(){
        return countyRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(County::getName))
                .collect(Collectors.toList());
    }
}
