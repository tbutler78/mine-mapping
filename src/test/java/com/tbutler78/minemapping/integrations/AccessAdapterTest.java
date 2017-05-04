package com.tbutler78.minemapping.integrations;


import com.tbutler78.minemapping.MineMappingApplicationTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;


public class AccessAdapterTest extends MineMappingApplicationTest {
    Logger log = LoggerFactory.getLogger(MineMappingApplicationTest.class);

    @Autowired
    AccessAdapter accessAdapter;


    @Test
    public void testDb() throws SQLException {
        AccessTable results = accessAdapter.getResultSet("SELECT * FROM MINES", 100);

    }

    @Test
    public void testCounty() throws SQLException {
        AccessTable results = accessAdapter.getResultSet("select * from County100k", 500);
    }
}
