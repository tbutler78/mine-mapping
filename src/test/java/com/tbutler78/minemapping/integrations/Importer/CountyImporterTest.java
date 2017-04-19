package com.tbutler78.minemapping.integrations.Importer;

import com.tbutler78.minemapping.MineMappingApplicationTest;
import com.tbutler78.minemapping.integrations.importer.CountyImporter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

/**
 * Created by butlert on 4/12/17.
 */
@Transactional
public class CountyImporterTest extends MineMappingApplicationTest {
    @Autowired
    CountyImporter countyImporter;

    @Test
    public void testCountyImporter(){
        countyImporter.processData();
    }
}
