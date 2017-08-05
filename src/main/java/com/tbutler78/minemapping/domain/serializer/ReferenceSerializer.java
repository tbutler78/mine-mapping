package com.tbutler78.minemapping.domain.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.tbutler78.minemapping.domain.Reference;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class ReferenceSerializer {


     static class ReferenceJsonSerializer {
        //extends JsonSerializer<Reference> {

   // @Override
    public void serialize(Reference reference, JsonGenerator jsonGenerator) throws IOException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("title", reference.getTitle());
        jsonGenerator.writeStringField("href", reference.getHyperlink());
        jsonGenerator.writeStringField("year", reference.getYearDate());
        jsonGenerator.writeStringField("publisher", reference.getPublisher());
        jsonGenerator.writeStringField("refIds", reference.getReferenceRelates().toString());

        jsonGenerator.writeEndObject();
    }


    private static String[] getSummary(Reference reference) {
        List<String> summary =  new ArrayList<>();

       summary.add(reference.getHyperlink());
       summary.add(reference.getYearDate());
        // return String.format("#%02x%02x%02x", r, g, b);
        return summary.toArray(new String[0]);
    }
}}