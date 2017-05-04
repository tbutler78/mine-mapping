package com.tbutler78.minemapping.integrations.importer;

import com.tbutler78.minemapping.integrations.AccessAdapter;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Importer {

    AccessAdapter accessAdapter;

    @Autowired
    public Importer(AccessAdapter accessAdapter) {
        this.accessAdapter = accessAdapter;
    }

    protected Importer() {
    }

    //abstract public boolean getData();
}
