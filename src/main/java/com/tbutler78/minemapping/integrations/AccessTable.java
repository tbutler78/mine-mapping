package com.tbutler78.minemapping.integrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AccessTable {

    private final List<Map<String, String>>  rows;

    public AccessTable (){
        rows= new ArrayList<>();
    }

    public void addRow(Map<String, String> value ){
        rows.add(value);
    }

    public List<Map<String, String>> getRows() {
        return rows;
    }

    @Override
    public String toString() {
        return "AccessTable{" +
                "row=" + rows +
                '}';
    }
}
