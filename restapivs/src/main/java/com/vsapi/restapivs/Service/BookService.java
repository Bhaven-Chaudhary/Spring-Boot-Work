package com.vsapi.restapivs.Service;

import java.util.List;

import com.vsapi.restapivs.Dao.BookRepository;
import com.vsapi.restapivs.Entity.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBook() {
        List<Book> books = (List<Book>) bookRepository.findAll();
        return books;
    }

    public Book getBook(int id) {
        Book book = bookRepository.findById(id);
        return book;
    }

    public Book addBook(Book book) {
        Book savedBook = bookRepository.save(book);
        return savedBook;
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    public void update(Book book, int id) {
        book.setId(id);
        bookRepository.save(book);
    }

}
