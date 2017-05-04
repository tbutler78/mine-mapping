package com.tbutler78.minemapping.integrations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AccessTable {

    private final List<HashMap<String, String>>  rows;

    AccessTable (){
        rows= new ArrayList<>();
    }

    public void addRow(HashMap<String, String> value ){
        rows.add(value);
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
