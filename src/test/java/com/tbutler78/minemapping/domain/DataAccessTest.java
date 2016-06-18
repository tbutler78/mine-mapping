package com.tbutler78.minemapping.domain;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DataAccessTest {

    public static void main(String args[]) {
        // simple DS for test (not for production!)
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        //dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUsername("sa");
        dataSource.setUrl("jdbc:hsqldb:mem:testdb;shutdown=true");
        //dataSource.setPassword("adpcarsql");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        /*
        System.out.println("Creating tables");
        jdbcTemplate.execute("drop table customers if exists");
        jdbcTemplate.execute("create table customers(" +
                "id serial, first_name varchar(255), last_name varchar(255))");

        String[] names = "John Woo;Jeff Dean;Josh Bloch;Josh Long".split(";");
        for (String fullname : names) {
            String[] name = fullname.split(" ");
            System.out.printf("Inserting customer record for %s %s\n", name[0], name[1]);
            jdbcTemplate.update(
                    "INSERT INTO customers(first_name,last_name) values(?,?)",
                    name[0], name[1]);
        }
	*/
        System.out.println("Querying for customer records where first_name = 'Josh':");
        List<Location> results = jdbcTemplate.query(
        		 "select * from idahomines.mines",
                 new RowMapper<Location>() {
                     @Override
                     public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
                    	 Location location = new Location();
                    	 location.setDeposit(rs.getString("DEPOSIT"));
                    	 location.setLatitude(rs.getDouble("Latitude"));
                    	 location.setLongitude(rs.getDouble("Longitude"));
                         return location;
                     }
                 });
        		
        /*
        List<Customer> results = jdbcTemplate.query(
                "select * from customers where first_name = ?", new Object[] { "Josh" },
                new RowMapper<Customer>() {
                    @Override
                    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Customer(rs.getLong("id"), rs.getString("first_name"),
                                rs.getString("last_name"));
                    }
                });
*/
        for (Location location : results) {
            System.out.println(location.getDeposit());
            System.out.println(location.getLatitude());
        }
    }
}
