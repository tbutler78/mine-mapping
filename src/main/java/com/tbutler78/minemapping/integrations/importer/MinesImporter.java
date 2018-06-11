package com.tbutler78.minemapping.integrations.importer;

import com.tbutler78.minemapping.domain.County;
import com.tbutler78.minemapping.domain.Mine;
import com.tbutler78.minemapping.integrations.AccessTable;
import com.tbutler78.minemapping.repository.CountyRepository;
import com.tbutler78.minemapping.repository.MineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Created by butlert on 4/12/17.
 */

@Component
public class MinesImporter extends Importer {
    Logger log = LoggerFactory.getLogger(MinesImporter.class);

    @Autowired
    MineRepository  mineRepository;

    public void processData(){
        getData().getRows().stream().forEach( t -> {
            log.info("Processing Mine");
            String sequenceNumber = t.get("SequenceNumber");
            Mine mine;
            try {

                mine = mineRepository.findOneBySequenceNumber(sequenceNumber);
                if (mine == null) {
                   mine = new Mine();
                   buildMine(mine, t);
                   log.info("Adding " + mine.toString());
                    mineRepository.save(mine);

                } else {
                    mine = buildMine(mine, t);
                    log.info("updating: " + mine.toString());
                    mineRepository.save(mine);
                }
            } catch (Exception e){
                log.error("Error Processing Mine");

                log.error(e.toString());
            }}

        );

    }

    private Mine buildMine(Mine mine, HashMap<String, String> props){
        // Missing QSection
        mine.setSequenceNumber(props.get("SequenceNumber"));
        mine.setDeposit(props.get("DEPOSIT"));
        mine.setLatitude(new BigDecimal((props.get("Latitude"))));
        mine.setLongitude(new BigDecimal((props.get("Longitude"))));
        mine.setLongwgs(new BigDecimal(props.get("lon_WGS84")));
        mine.setLatwgs(new BigDecimal(props.get("lat_WGS84")));
        mine.setNewLoc(props.get("NEWLOC"));
        mine.setMapLoc(props.get("MAPLOC").trim());
        mine.setLocationType(props.get("Location_type"));
        mine.setDmsLat(new BigDecimal(props.get("DMSLAT")));
        mine.setDmsLong(new BigDecimal(props.get("DMSLONG")));
        mine.setTwentyFourQuad(props.get("twentyFourKQuad"));
        mine.setOneHundredQuad(props.get("HundredKQuad"));
        mine.setCountyName(props.get("CountyName"));
        mine.setLandOwner(props.get("LandOwner"));
        mine.setFsAgencyName(props.get("FSAgencyName"));
        mine.setOrangeNum(props.get("OrangeNum"));
        mine.setOneByTwoDegreeQuad(props.get("1x2degreeQuadrangle"));
        mine.setTownship(props.get("TOWNSHIP"));
        mine.setRange(props.get("RANGE"));
        mine.setSection(props.get("SECTION"));

        return mine;
    }

    protected AccessTable getData() {
        return
                accessAdapter.getResultSet("SELECT * FROM Mines", 10000);

    }}
