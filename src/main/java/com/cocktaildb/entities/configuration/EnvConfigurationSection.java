package com.cocktaildb.entities.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnvConfigurationSection {
    @JsonProperty("protocol")
    public String protocol;
    @JsonProperty("baseHostPostfix")
    public String baseHostPostfix;
}