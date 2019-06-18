package com.tbutler78.minemapping.integrations.importer;

import com.tbutler78.minemapping.domain.Name;
import com.tbutler78.minemapping.repository.NameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * Created by butlert on 4/12/17.
 */

@Component
public class NameImporter extends Importer {
    Logger log = LoggerFactory.getLogger(NameImporter.class);

    @Autowired
    NameRepository nameRepository;

    @Override
    public void processData(){
        getData().forEach( t -> {
            String nameKey = t.get("NameKey");
            log.info(nameKey);

          try {

                Name name = new Name();
                name.setSequenceNumber(t.get("SequenceNumber"));
                name.setMetric(Long.parseLong(t.get("Metric")));
                name.setAutoNumber(Long.parseLong(t.get("AutoNumber")));
                name.setNameKey(t.get("NameKey"));
                name.setrIndexDepositFieldName(t.get("R_Index2_Deposit_FieldName"));
                name.setSeparatedNamesDepositFieldName(t.get("SeparatedNames_Deposit_FieldName"));

                log.info("Processing: " + name.toString());
                      nameRepository.save(name);
                      log.info(name.toString());
                } catch (Exception e){
                    log.error(e.toString());
                }




        });

    }

    protected List<HashMap<String, String>> getData() {
        return
                accessAdapter.getResultSet("SELECT * FROM Names", 1000).getRows();

    }}
