package com.tbutler78.minemapping.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "property_file_scans")
public class PropertyFileScan implements Serializable {

    @Id
    private int id;

    private String propertyNumber;

    private String propertyScanName;

    private String originalFileName;

    private String fileSize;

    private String fileName;

    private String itemType;

    private String infoText;

    private String maps;

    private String author;

    private String comments;

    private String folderName;

    private String dates;

    private String mapsToReview;

    private boolean reScanFile;

    private String crossRefPropertiesComments;

    private String year;

    private String company;

    private String initials;

    private String entryDate;

    public PropertyFileScan() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPropertyNumber() {
        return propertyNumber;
    }

    public void setPropertyNumber(String propertyNumber) {
        this.propertyNumber = propertyNumber;
    }

    public String getPropertyScanName() {
        return propertyScanName;
    }

    public void setPropertyScanName(String propertyScanName) {
        this.propertyScanName = propertyScanName;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getInfoText() {
        return infoText;
    }

    public void setInfoText(String infoText) {
        this.infoText = infoText;
    }

    public String getMaps() {
        return maps;
    }

    public void setMaps(String maps) {
        this.maps = maps;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getMapsToReview() {
        return mapsToReview;
    }

    public void setMapsToReview(String mapsToReview) {
        this.mapsToReview = mapsToReview;
    }

    public boolean isReScanFile() {
        return reScanFile;
    }

    public void setReScanFile(boolean reScanFile) {
        this.reScanFile = reScanFile;
    }

    public String getCrossRefPropertiesComments() {
        return crossRefPropertiesComments;
    }

    public void setCrossRefPropertiesComments(String crossRefPropertiesComments) {
        this.crossRefPropertiesComments = crossRefPropertiesComments;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public String toString() {
        return "PropertyFileScan{" +
                "id=" + id +
                ", propertyNumber='" + propertyNumber;
    }


}
