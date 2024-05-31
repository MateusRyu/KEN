package br.dev.ryu.ken.service;

import br.dev.ryu.ken.model.Book;
import br.dev.ryu.ken.model.ListOfBooks;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class GutendexConsumer implements IApiConsumer {
    private final String URL = "https://gutendex.com";
    private final WebApiConnector WEB_API_CONNECTOR = new WebApiConnector(15);
    private final IDataBinder DATA_BINDER = new DataBinder();

    @Override
    public ListOfBooks getBooksByTitle(String title) {
        String url = URL + "/books?search=" + URLEncoder.encode(title, StandardCharsets.UTF_8);
        String json = WEB_API_CONNECTOR.getDataFromURL(url);
        return DATA_BINDER.bindJsonToClass(json, ListOfBooks.class);
    }

    @Override
    public List<Book> getBooksFromListOfBooks(ListOfBooks listOfBooks) {
        String json;
        List<Book> books = listOfBooks.books().stream()
                .map(Book::new)
                .collect(Collectors.toList());

        while (listOfBooks.nextPageUrl() != null) {
            System.out.println(listOfBooks.nextPageUrl());
            json = WEB_API_CONNECTOR.getDataFromURL(listOfBooks.nextPageUrl());
            listOfBooks = DATA_BINDER.bindJsonToClass(json, ListOfBooks.class);
            listOfBooks.books().stream()
                    .map(Book::new)
                    .forEach(books::add);
        }

        return books;
    }
}
