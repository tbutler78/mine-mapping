package com.tbutler78.minemapping.system;

import com.tbutler78.minemapping.integrations.importer.CountyImporter;
import com.tbutler78.minemapping.integrations.importer.MinesImporter;
import com.tbutler78.minemapping.integrations.importer.NameImporter;
import com.tbutler78.minemapping.integrations.importer.PropertyFileScanImporter;
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
    private final PropertyFileScanImporter propertyFileScanImporter;

    @Autowired
    public ApplicationStartup(CountyImporter countyImporter, MinesImporter minesImporter, NameImporter nameImporter, PropertyFileScanImporter propertyFileScanImporter) {
        this.countyImporter = countyImporter;
        this.minesImporter = minesImporter;
        this.nameImporter = nameImporter;
        this.propertyFileScanImporter = propertyFileScanImporter;
    }

    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
/*
        propertyFileScanImporter.processData();

        nameImporter.processData();
        countyImporter.processData();
        minesImporter.processData();
*/
        return;
    }

} // class
