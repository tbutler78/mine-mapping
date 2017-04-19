package com.tbutler78.minemapping.domain.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.tbutler78.minemapping.domain.Reference;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@JsonComponent
public class ReferenceSerializer {


@SuppressWarnings("UnusedShould")
public static class ReferenceJsonSerializer {
        //extends JsonSerializer<Reference> {

   // @Override
    public void serialize(Reference reference, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException,
            JsonProcessingException {

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

       summary.add(reference.getHyperlink().toString());
       summary.add(reference.getYearDate().toString());
        // return String.format("#%02x%02x%02x", r, g, b);
        return (String[]) summary.toArray();
    }
}}