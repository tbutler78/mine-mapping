package com.tbutler78.minemapping.integrations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by butlert on 4/10/17.
 */
public class AccessTable {

    private List<HashMap<String, String>>  rows;

    AccessTable (){
        rows= new ArrayList<>();
    }

    public void addRow(Map<String, String> value ){
        rows.add((HashMap<String, String>) value);
    }

    public List<HashMap<String, String>> getRows() {
        return rows;
    }

    @Override
    public String toString() {
        return "AccessTable{" +
                "row=" + rows +
                '}';
    }
}
