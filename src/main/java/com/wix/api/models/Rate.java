package com.wix.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "r030",
        "txt",
        "rate",
        "cc",
        "exchangedate"
})
public class Rate {

    @JsonProperty("r030")
    public Integer r030;
    @JsonProperty("txt")
    public String txt;
    @JsonProperty("rate")
    public Double rate;
    @JsonProperty("cc")
    public String cc;
    @JsonProperty("exchangedate")
    public String exchangedate;

}