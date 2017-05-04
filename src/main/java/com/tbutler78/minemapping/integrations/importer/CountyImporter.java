package com.tbutler78.minemapping.integrations.importer;

import com.tbutler78.minemapping.domain.County;
import com.tbutler78.minemapping.integrations.AccessTable;
import com.tbutler78.minemapping.repository.CountyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;


@Component
public class CountyImporter extends Importer {
    private final Logger log = LoggerFactory.getLogger(CountyImporter.class);

    private final CountyRepository countyRepository;

    @Autowired
    public CountyImporter(CountyRepository countyRepository) {
        this.countyRepository = countyRepository;
    }

    public void processData(){
        try {
            getData().getRows().forEach(t -> {
				String countyName = t.get("Countyname");
				if (countyRepository.findAllByName(countyName).isEmpty()){
					County county = new County(countyName);
					countyRepository.save(county);
				}
			});
        } catch (SQLException e) {
           log.info(e.toString());
        }

    }

    private AccessTable getData() throws SQLException {
        return
             accessAdapter.getResultSet("SELECT * FROM County", 1000);

}}
