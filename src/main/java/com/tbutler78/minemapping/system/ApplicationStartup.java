package com.tbutler78.minemapping.system;

import com.tbutler78.minemapping.integrations.AccessAdapter;
import com.tbutler78.minemapping.integrations.importer.CountyImporter;
import com.tbutler78.minemapping.integrations.importer.MinesImporter;
import com.tbutler78.minemapping.integrations.importer.NameImporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup
    implements ApplicationListener<ApplicationReadyEvent> {

    private final CountyImporter countyImporter;
    private final MinesImporter minesImporter;
    private final NameImporter nameImporter;

    @Autowired
    public ApplicationStartup(CountyImporter countyImporter, MinesImporter minesImporter, NameImporter nameImporter) {
        this.countyImporter = countyImporter;
        this.minesImporter = minesImporter;
        this.nameImporter = nameImporter;
    }

    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        nameImporter.processData();
        countyImporter.processData();
        minesImporter.processData();

        return;
    }

} // class
