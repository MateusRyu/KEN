package br.dev.ryu.ken.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Book {
    private int id;
    private List<Person> authors = new ArrayList<>();
    private String title;
    private List<String> subjects;
    private List<Person> translators = new ArrayList<>();
    private List<String> bookshelves;
    private List<String> languages;
    private Optional<Boolean> copyright;
    private String mediaType;
    private Format format;
    private int downloadCount;


    public Book(BookData book) {
        book.authors().stream()
                .map(Person::new)
                .forEach(p -> {
                    if (this.authors != null) {
                        this.authors.add(p);
                    }
                });

        this.bookshelves = book.bookshelves();
        this.copyright = Optional.of(book.copyright());
        this.title = book.title();
        this.subjects = book.subjects();

        book.translators().stream()
                .map(Person::new)
                .forEach(this.translators::add);

        this.languages = book.languages();
        this.mediaType = book.mediaType();
        this.format = book.format();
        this.downloadCount = book.downloadCount();
    }

    @Override
    public String toString() {
        StringBuilder citation = new StringBuilder();
        boolean big = this.authors.size() > 3;
        List<String> authors =  this.authors.stream()
                .sorted((a1, a2) -> a1.getName().compareTo(a2.getName()))
                .limit(3)
                .map(Person::getName)
                .toList();

        for (int i = 0; i < authors.size(); i++) {
            citation.append(authors.get(i));
            if (i == authors.size() - 2) {
                citation.append(" and ");
            } else if (authors.size() != 1 && i == authors.size() - 1) {
                citation.append(", ");
            }

            if (big) {
                citation.append(" et. al");
            };
        }
        return String.format("%s (%s)", this.title, citation);
    }
}
