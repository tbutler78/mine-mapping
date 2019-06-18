package com.tbutler78.minemapping.integrations.importer;

import com.tbutler78.minemapping.integrations.AccessAdapter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

/**
 * Created by butlert on 4/12/17.
 */

public abstract class Importer {

    @Autowired
    protected AccessAdapter accessAdapter;
    abstract void processData();
    abstract List<HashMap<String, String>> getData();
}
