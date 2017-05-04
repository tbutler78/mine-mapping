package com.tbutler78.minemapping.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name="reference")
public class Reference {

    @Id
    private Long id;
    private String sheetCount;
    private String anno;
    private String notes;
    private String referenceId;
    private String pageCount;
    private String origin;
    private String edition;
    private String scale;
    private String oldReference;
    private String urlIntra;
    private String title;
    private String seriesType;
    private String secondTitle;
    private String number;
    private String institution;
    private String pubNumber;
    private String pages;
    private String yearDate;
    private String pubCity;
    private String plateCount;
    private String secondTitleDate;
    private String pubId;
    private String hyperlink;
    private String yearHyperlink;
    private String urlYear;
    private String enterDate;
    private String isIn;
    private String initials;
    private String publisherAbbv;
    @JsonProperty("abstract")
    private String refAbstract;
    private String url;
    private String volume;
    private String folder;
    private String fileName;
    private String nd;
    private String pubState;

    private String publisher;
    private String editDate;



    @Transient
    private List<ReferenceRelate> referenceRelates;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSheetCount() {
        return sheetCount;
    }

    public void setSheetCount(String sheetCount) {
        this.sheetCount = sheetCount;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getOldReference() {
        return oldReference;
    }

    public void setOldReference(String oldReference) {
        this.oldReference = oldReference;
    }

    public String getUrlIntra() {
        return urlIntra;
    }

    public void setUrlIntra(String urlIntra) {
        this.urlIntra = urlIntra;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSeriesType() {
        return seriesType;
    }

    public void setSeriesType(String seriesType) {
        this.seriesType = seriesType;
    }

    public String getSecondTitle() {
        return secondTitle;
    }

    public void setSecondTitle(String secondTitle) {
        this.secondTitle = secondTitle;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getPubNumber() {
        return pubNumber;
    }

    public void setPubNumber(String pubNumber) {
        this.pubNumber = pubNumber;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getYearDate() {
        return yearDate;
    }

    public void setYearDate(String yearDate) {
        this.yearDate = yearDate;
    }

    public String getPubCity() {
        return pubCity;
    }

    public void setPubCity(String pubCity) {
        this.pubCity = pubCity;
    }

    public String getPlateCount() {
        return plateCount;
    }

    public void setPlateCount(String plateCount) {
        this.plateCount = plateCount;
    }

    public String getSecondTitleDate() {
        return secondTitleDate;
    }

    public void setSecondTitleDate(String secondTitleDate) {
        this.secondTitleDate = secondTitleDate;
    }

    public String getPubId() {
        return pubId;
    }

    public void setPubId(String pubId) {
        this.pubId = pubId;
    }

    public String getHyperlink() {
        return hyperlink;
    }

    public void setHyperlink(String hyperlink) {
        this.hyperlink = hyperlink;
    }

    public String getYearHyperlink() {
        return yearHyperlink;
    }

    public void setYearHyperlink(String yearHyperlink) {
        this.yearHyperlink = yearHyperlink;
    }

    public String getUrlYear() {
        return urlYear;
    }

    public void setUrlYear(String urlYear) {
        this.urlYear = urlYear;
    }

    public String getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(String enterDate) {
        this.enterDate = enterDate;
    }

    public String getIsIn() {
        return isIn;
    }

    public void setIsIn(String in) {
        this.isIn = in;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getPublisherAbbv() {
        return publisherAbbv;
    }

    public void setPublisherAbbv(String publisherAbbv) {
        this.publisherAbbv = publisherAbbv;
    }

    public String getRefAbstract() {
        return refAbstract;
    }

    public void setRefAbstract(String refAbstract) {
        this.refAbstract = refAbstract;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getNd() {
        return nd;
    }

    public void setNd(String nd) {
        this.nd = nd;
    }

    public String getPubState() {
        return pubState;
    }

    public void setPubState(String pubState) {
        this.pubState = pubState;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getEditDate() {
        return editDate;
    }

    public void setEditDate(String editDate) {
        this.editDate = editDate;
    }

    public List<ReferenceRelate> getReferenceRelates() {
        return referenceRelates;
    }

    public void setReferenceRelates(List<ReferenceRelate> referenceRelates) {
        this.referenceRelates = referenceRelates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reference that = (Reference) o;

        return Objects.equals(this.anno, that.anno) &&
                Objects.equals(this.editDate, that.editDate) &&
                Objects.equals(this.edition, that.edition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(anno, editDate, edition, enterDate, fileName, folder,
                hyperlink, isIn, initials, institution, nd,
                notes, number, oldReference, origin, pageCount,
                pages, plateCount, pubCity, pubId, publisher,
                publisherAbbv, pubNumber, pubState, refAbstract, referenceId,
                scale, secondTitle, secondTitleDate, seriesType, sheetCount,
                title, url, urlIntra, urlYear, volume,
                yearDate, yearHyperlink);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("anno = " + anno)
                .add("editDate = " + editDate)
                .add("edition = " + edition)
                .add("enterDate = " + enterDate)
                .add("fileName = " + fileName)
                .add("folder = " + folder)
                .add("hyperlink = " + hyperlink)
                .add("in = " + isIn)
                .add("initials = " + initials)
                .add("institution = " + institution)
                .add("nd = " + nd)
                .add("notes = " + notes)
                .add("number = " + number)
                .add("oldReference = " + oldReference)
                .add("origin = " + origin)
                .add("pageCount = " + pageCount)
                .add("pages = " + pages)
                .add("plateCount = " + plateCount)
                .add("pubCity = " + pubCity)
                .add("pubId = " + pubId)
                .add("publisher = " + publisher)
                .add("publisherAbbv = " + publisherAbbv)
                .add("pubNumber = " + pubNumber)
                .add("pubState = " + pubState)
                .add("refAbstract = " + refAbstract)
                .add("referenceId = " + referenceId)
                .add("scale = " + scale)
                .add("secondTitle = " + secondTitle)
                .add("secondTitleDate = " + secondTitleDate)
                .add("seriesType = " + seriesType)
                .add("sheetCount = " + sheetCount)
                .add("title = " + title)
                .add("url = " + url)
                .add("urlIntra = " + urlIntra)
                .add("urlYear = " + urlYear)
                .add("volume = " + volume)
                .add("yearDate = " + yearDate)
                .add("yearHyperlink = " + yearHyperlink)
                .toString();
    }
}