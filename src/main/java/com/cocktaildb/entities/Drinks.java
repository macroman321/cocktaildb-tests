package com.cocktaildb.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Drinks {

    @JsonProperty("drinks")
    private List<Drink> drinks = null;

}
