package br.dev.ryu.ken.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ListOfBooks(
        @JsonAlias("count") int count,
        @JsonAlias("next") String nextPageUrl,
        @JsonAlias("previous") String previousPageUrl,
        @JsonAlias("results") List<BookData> books) {
}
