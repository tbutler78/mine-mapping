package com.tbutler78.minemapping.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.StringJoiner;

@Entity
@Table(name="reference_relate")
public class ReferenceRelate {
    @Id
    private Long id;
    private String reference;
    private String sequenceNumber;
    private String refId;
    private String notesForReferenceUpdate2015;
    private String pageNumbers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getNotesForReferenceUpdate2015() {
        return notesForReferenceUpdate2015;
    }

    public void setNotesForReferenceUpdate2015(String notesForReferenceUpdate2015) {
        this.notesForReferenceUpdate2015 = notesForReferenceUpdate2015;
    }

    public String getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(String pageNumbers) {
        this.pageNumbers = pageNumbers;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("id = " + id)
                .add("notesForReferenceUpdate2015 = " + notesForReferenceUpdate2015)
                .add("pageNumbers = " + pageNumbers)
                .add("reference = " + reference)
                .add("refId = " + refId)
                .add("sequenceNumber = " + sequenceNumber)
                .toString();
    }
}