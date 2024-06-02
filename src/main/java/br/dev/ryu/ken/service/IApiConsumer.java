package br.dev.ryu.ken.service;

import br.dev.ryu.ken.model.Book;
import br.dev.ryu.ken.model.BookData;
import br.dev.ryu.ken.model.ListOfBooks;

import java.util.List;

public interface IApiConsumer {
    ListOfBooks getBooksByTitle(String title);
    List<Book> getBooksFromListOfBooks(ListOfBooks listOfBooks);
    BookData getBookById(String id);
}
