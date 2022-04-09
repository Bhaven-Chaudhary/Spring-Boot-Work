package com.vsapi.restapivs.Service;

import java.util.ArrayList;
import java.util.List;

import com.vsapi.restapivs.Entity.Book;

import org.springframework.stereotype.Component;

@Component
public class BookService {

    List<Book> bookList = new ArrayList<Book>();

    public List<Book> getAllBook() {
        return bookList;
    }

    public boolean addBook(Book book) {
        boolean isadded = bookList.add(book);
        return isadded;
    }

    public Book deleteBook(int id) {
        Book booktodelete = bookList.stream().filter(book -> id == (book.getId())).findAny().get();
        bookList.remove(booktodelete);
        return booktodelete;
    }

}
