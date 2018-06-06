package com.tbutler78.minemapping.integrations.importer;

import com.tbutler78.minemapping.domain.County;
import com.tbutler78.minemapping.integrations.AccessTable;
import com.tbutler78.minemapping.repository.CountyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by butlert on 4/12/17.
 */

@Component
public class CountyImporter extends Importer {
    Logger log = LoggerFactory.getLogger(CountyImporter.class);

    @Autowired
    CountyRepository countyRepository;

    public void processData(){
    getData().getRows().stream().forEach( t -> {
        String countyName = t.get("Countyname");
        if (countyRepository.findAllByName(countyName).size() < 1){
            County county = new County(countyName);
            try {
            countyRepository.save(county);

        } catch(Exception e) {
                log.info(countyName);
                log.info(countyRepository.findAllByName(countyName).toString());
                log.info(e.toString());
            }
            }

    });

    }

    protected AccessTable getData() {
        return
             accessAdapter.getResultSet("SELECT * FROM County", 1000);

}}
