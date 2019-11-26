package com.cocktaildb.entities.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnvConfiguration {
    @JsonProperty("LOCAL")
    public EnvConfigurationSection localEnv;
    @JsonProperty("PROD")
    public EnvConfigurationSection prodEnv;

    public EnvConfigurationSection getConfig(String envName) {
        switch (envName.toUpperCase()) {
            case "LOCAL ":
                return localEnv;
            case "PROD":
                return prodEnv;
            default:
                return null;
        }
    }
}