package com.tbutler78.minemapping.integrations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.HashMap;


@Component
public class AccessAdapter {

	private final Logger log = LoggerFactory.getLogger(AccessAdapter.class);

    String MS_ACC_DB = "src/main/resources/batch/MinesAndProspects_1.2015.1.mdb";

    String DB_URL = "jdbc:ucanaccess://" + MS_ACC_DB;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;


// "SELECT * FROM PLAYER"

    public AccessTable getResultSet(String query, int maxRows) {
        AccessTable accessTable = new AccessTable();

        try {

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException cnfex) {

            log.error("Problem in loading or "
                                       + "registering MS Access JDBC driver");
            log.error(cnfex.getException().toString());
        }

        try {

            connection = DriverManager.getConnection(DB_URL); //Create and get connection using DriverManager class
            statement = connection.createStatement(); // Create JDBC Statement
            resultSet = statement.executeQuery(query); //Execute SQL & retrieve data into ResultSet
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columns = rsmd.getColumnCount();

            int counter = 0;


            HashMap<String, String> result;
            // processing returned data and printing into console


            while(resultSet.next() && counter < maxRows) {
                counter++;
                result = new HashMap<>();
                for (int i=1; i<=columns; i++){
                    result.put(rsmd.getColumnName(i), resultSet.getString(i) != null ? resultSet.getString(i) : "");
                                  }
                accessTable.addRow(result);

            }

        }
        catch(SQLException sqlex){
            log.error(sqlex.toString());
        }
        finally {

            // Step 3: Closing database connection
            try {
                if(null != connection) {

                    // cleanup resources, once after processing
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                    // and then finally close connection
                    connection.close();
                }
            }
            catch (SQLException sqlex) {
               log.error(sqlex.toString());
            }
        }
        return accessTable;
    }
}

