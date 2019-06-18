package com.tbutler78.minemapping.integrations.importer;

import com.tbutler78.minemapping.domain.PropertyFileScan;
import com.tbutler78.minemapping.repository.PropertyFileScanRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class PropertyFileScanImporter extends Importer {
    Logger log = LoggerFactory.getLogger(PropertyFileScanImporter.class);

    @Autowired
    PropertyFileScanRepository propertyFileScanRepository;

    @Override
    public void processData() {
        getData().forEach(t ->{
            log.info(t.get("FileName") + " " +  t.get("InfoText"));
            PropertyFileScan pfs = new PropertyFileScan();
            pfs.setAuthor(t.get("Author"));
            pfs.setComments(t.get("Comments"));
            pfs.setCompany(t.get("Company"));
            pfs.setCrossRefPropertiesComments(t.get("Cross-Ref Properties Comments"));
            pfs.setDates(t.get("Dates"));
            pfs.setEntryDate(t.get("EntryDate"));
            pfs.setFileName(t.get("FileName"));
            pfs.setFileSize(t.get("FileSize"));
            pfs.setFolderName(t.get("FolderName"));
            pfs.setInfoText(t.get("InfoText"));
            pfs.setInitials(t.get("Initials"));
            pfs.setItemType(t.get("ItemType"));
            pfs.setMaps(t.get("Maps"));
            pfs.setMapsToReview(t.get("MapsToReview"));
            pfs.setOriginalFileName(t.get("OriginalFileName"));
            pfs.setPropertyNumber(t.get("PropertyNumber"));
            pfs.setPropertyScanName(t.get("PropertyScanName"));
            pfs.setReScanFile(Boolean.valueOf(t.get("Re-scan file")));
            pfs.setYear(t.get("Year"));

            //Cross-Ref Properties Comments=, Company=, PropertyScanName=BA0017-m001, OriginalFileName=,
            // Re-scan file=FALSE, Comments=, FileName=BA0017-m001.pdf, ItemType=map, Dates=undated,
            // MapsToReview=, Initials=, FolderName=, InfoText=Geologic Map of Lead Zone Mine area,
            // Year=undated, EntryDate=, PropertyNumber=BA0017, Author=, ID=1, FileSize=
            pfs = propertyFileScanRepository.save(pfs);
            log.info(pfs.toString());

        });
    }

    @Override
    List<HashMap<String, String>> getData() {
        return accessAdapter.getResultSet("SELECT * FROM PropertyFileScans", 100).getRows();
    }
}
