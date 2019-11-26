package com.cocktaildb.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Ingredient {


    @JsonProperty("idIngredient")
    private String idIngredient;

    @JsonProperty("strIngredient")
    private String strIngredient;

    @JsonProperty("strDescription")
    private String strDescription;

    @JsonProperty("strType")
    private String strType;

    @JsonProperty("strAlcohol")
    private String strAlcohol;

    @JsonProperty("strABV")
    private String strABV;

}
