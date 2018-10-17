package com.tbutler78.minemapping.domain.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.tbutler78.minemapping.domain.Mine;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * Created by butlert on 4/16/17.
 */
@JsonComponent
public class MineSerializer {

    private MineSerializer(){

    }

    public static class MineJsonSerializer {





        public void serialize(Mine mine, JsonGenerator jsonGenerator) throws IOException {

            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField(
                    "summary", getSummary(mine));
            jsonGenerator.writeStringField("Latitude", (mine.getLatitude().toString()));
            jsonGenerator.writeStringField("longitude", mine.getLongitude().toString());
            jsonGenerator.writeEndObject();
        }

        private static String getSummary(Mine mine) {
            return mine.getDeposit() + mine.getLandOwner();

        }
    }

    public static class MineJsonDeserializer
            extends JsonDeserializer<Mine> {

        @Override
        public Mine deserialize(JsonParser jsonParser,
                                DeserializationContext deserializationContext)
                throws IOException {

                        return new Mine();
        }
    }
}
