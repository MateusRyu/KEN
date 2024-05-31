package br.dev.ryu.ken.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(@JsonAlias("id") int id,
                       @JsonAlias("authors") List<PersonData> authors,
                       @JsonAlias("title") String title,
                       @JsonAlias("subjects") List<String> subjects,

                       @JsonAlias("translators") List<PersonData> translators,
                       @JsonAlias("bookshelves") List<String> bookshelves,
                       @JsonAlias("languages") List<String> languages,
                       @JsonAlias("copyright") boolean copyright,
                       @JsonAlias("mediaType") String mediaType,
                       @JsonAlias("format") Format format,
                       @JsonAlias("downloadCount") int downloadCount) {
}
