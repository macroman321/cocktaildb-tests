package com.cocktaildb.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Ingredients {

    @JsonProperty("ingredients")
    private List<Ingredient> ingredients;

}
