package db.Names.csv;

/**
 * Created by JacksonGenerator on 4/17/17.
 */

import com.fasterxml.jackson.annotation.JsonProperty;


public class Name {
    @JsonProperty("Names")
    private String names;
    @JsonProperty("SequenceNumber")
    private String sequenceNumber;
    @JsonProperty("CompositeName")
    private String compositeName;
    @JsonProperty("Metric")
    private String metric;
    @JsonProperty("Initials")
    private String initials;
    @JsonProperty("AutoNumber")
    private String autoNumber;
    @JsonProperty("NameKey")
    private String nameKey;
}