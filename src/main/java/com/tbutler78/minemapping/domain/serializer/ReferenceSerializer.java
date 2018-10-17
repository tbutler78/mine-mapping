package com.tbutler78.minemapping.domain.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.tbutler78.minemapping.domain.Reference;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class ReferenceSerializer {

    private ReferenceSerializer() {

    }

@SuppressWarnings("UnusedShould")
public static class ReferenceJsonSerializer {

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
}}