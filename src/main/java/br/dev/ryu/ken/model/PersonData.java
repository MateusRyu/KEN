package br.dev.ryu.ken.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PersonData(
        @JsonAlias("birth_year") int birthYear,
        @JsonAlias("death_year") int deathYear,
        String name) {
}
