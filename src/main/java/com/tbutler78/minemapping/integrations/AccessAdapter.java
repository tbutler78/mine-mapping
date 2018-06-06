package com.tbutler78.minemapping.integrations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Component
public class AccessAdapter {

    Logger log = LoggerFactory.getLogger(AccessAdapter.class);

    String MS_ACC_DB = "src/main/resources/batch/MinesAndProspects_1.2015.1.mdb";

    String DB_URL = "jdbc:ucanaccess://" + MS_ACC_DB;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;


// "SELECT * FROM PLAYER"

    public AccessTable getResultSet(String query, int maxRows) {
            List<String> results = new ArrayList<>();
        AccessTable accessTable = new AccessTable();

        try {

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException cnfex) {

            System.out.println("Problem in loading or "
                                       + "registering MS Access JDBC driver");
            cnfex.printStackTrace();
        }

        try {

            connection = DriverManager.getConnection(DB_URL); //Create and get connection using DriverManager class
            statement = connection.createStatement(); // Create JDBC Statement
            resultSet = statement.executeQuery(query); //Execute SQL & retrieve data into ResultSet
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columns = rsmd.getColumnCount();

            int counter = 0;

            System.out.println("ID\tName\t\t\tAge\tMatches");
            System.out.println("==\t================\t===\t=======");
            HashMap<String, String> result;
            // processing returned data and printing into console


            while(resultSet.next() && counter < maxRows) {
                counter++;
                result = new HashMap<>();
                for (int i=1; i<=columns; i++){
                    result.put(rsmd.getColumnName(i), resultSet.getString(i) != null ? resultSet.getString(i) : "");
                   // log.info(rsmd.getColumnTypeName(i) + " - " + rsmd.getColumnName(i));
                    // log.info((CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, rsmd.getColumnName(i))));
                }
                /*resultSet.toString();
                System.out.println(resultSet.getInt(1) + "\t" +
                                           resultSet.getString(2) + "\t" +
                                           resultSet.getString(3) + "\t" +
                                           resultSet.getString(4) + "\t" +
                     resultSet.getString(5));
*/
                accessTable.addRow(result);
log.info(result.toString());
            }

        }
        catch(SQLException sqlex){
            sqlex.printStackTrace();
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
                sqlex.printStackTrace();
            }
        }
        return accessTable;
    }
}

