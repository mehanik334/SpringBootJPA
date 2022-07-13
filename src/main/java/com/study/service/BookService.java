package com.study.service;

import com.study.model.Book;

import java.util.List;


public interface BookService {

    Book createBook(Book book);

    Book findById(Integer id);

    List<Book> getAll();

    Book editBook(Book book);

    void deleteBook(Integer id);
}
