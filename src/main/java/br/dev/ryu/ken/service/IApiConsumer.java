package br.dev.ryu.ken.service;

import br.dev.ryu.ken.model.Book;

import java.util.Optional;

public interface IApiConsumer {
    Optional<Book> getBookByTitle(String title);
}
