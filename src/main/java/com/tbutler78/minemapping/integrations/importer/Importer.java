package com.tbutler78.minemapping.integrations.importer;

import com.tbutler78.minemapping.integrations.AccessAdapter;
import com.tbutler78.minemapping.integrations.AccessTable;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by butlert on 4/12/17.
 */

public abstract class Importer {

    @Autowired
    protected AccessAdapter accessAdapter;
    abstract void processData();
    abstract AccessTable getData();
}
