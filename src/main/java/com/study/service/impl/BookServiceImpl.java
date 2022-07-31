package com.study.service.impl;

import com.study.model.Book;
import com.study.repository.BookRepository;
import com.study.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findById(Integer id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        Book book = null;
        if(optionalBook.isPresent()) {
            book = optionalBook.get();
        }else {
            throw new RuntimeException("Book with id " + id + " not found");
        }
        return book;
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book editBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }
}
