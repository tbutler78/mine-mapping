package com.tbutler78.minemapping.domain.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.TextNode;
import com.tbutler78.minemapping.domain.Mine;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * Created by butlert on 4/16/17.
 */
@JsonComponent
public class MineSerializer {

    public static class MineJsonSerializer {
            //extends JsonSerializer<Mine> {


        public void serialize(Mine mine, JsonGenerator jsonGenerator,
                              SerializerProvider serializerProvider) throws IOException,
                JsonProcessingException {

            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField(
                    "summary", getSummary(mine));
            jsonGenerator.writeStringField("Latitude", (mine.getLatitude().toString()));
            jsonGenerator.writeStringField("longitude", mine.getLongitude().toString());
            jsonGenerator.writeEndObject();
        }

        private static String getSummary(Mine mine) {
            return mine.getDeposit() + mine.getLandOwner();
           // return String.format("#%02x%02x%02x", r, g, b);
        }
    }

    public static class MineJsonDeserializer
            extends JsonDeserializer<Mine> {

        @Override
        public Mine deserialize(JsonParser jsonParser,
                                DeserializationContext deserializationContext)
                throws IOException, JsonProcessingException {

            TreeNode treeNode = jsonParser.getCodec().readTree(jsonParser);
            TextNode favoriteColor = (TextNode) treeNode.get(
                    "favoriteColor");
            return new Mine();
        }
    }
}
