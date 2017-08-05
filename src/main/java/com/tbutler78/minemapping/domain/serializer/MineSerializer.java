package com.tbutler78.minemapping.domain.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.tbutler78.minemapping.domain.Mine;
import java.io.IOException;

//@JsonComponent
class MineSerializer {

    public static class MineJsonSerializer {
            //extends JsonSerializer<Mine> {


        public void serialize(Mine mine, JsonGenerator jsonGenerator) throws IOException {

            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField(
                    "summary", getSummary(mine));
            jsonGenerator.writeStringField("Latitude", (mine.getLatitude().toString()));
            jsonGenerator.writeStringField("longitude", mine.getLongitude().toString());
            jsonGenerator.writeStringField("county", mine.getCountyName());
            jsonGenerator.writeEndObject();
        }

        private static String getSummary(Mine mine) {
            return mine.getDeposit() + mine.getLandOwner();
           // return String.format("#%02x%02x%02x", r, g, b);
        }
    }

    public class MineJsonDeserializer
            extends JsonDeserializer<Mine> {

        @Override
        public Mine deserialize(JsonParser jsonParser,
                                DeserializationContext deserializationContext)
                throws IOException {

          //  TreeNode treeNode = jsonParser.getCodec().readTree(jsonParser);
         //   TextNode favoriteColor = (TextNode) treeNode.get("favoriteColor");
            return new Mine();
        }
    }
}
