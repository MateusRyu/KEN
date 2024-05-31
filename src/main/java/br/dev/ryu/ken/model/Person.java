package br.dev.ryu.ken.model;

import java.util.Optional;

public class Person {
    private final Optional<Integer> birthYear;
    private Optional<Integer> deathYear;
    private String name;

    public Person(PersonData personData) {
        this.birthYear = Optional.of(personData.birthYear());
        this.deathYear = Optional.of(personData.deathYear());
        this.name = personData.name();
    }

    public Optional<Integer> getBirthYear() {
        return birthYear;
    }

    public Optional<Integer> getDeathYear() {
        return deathYear;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
