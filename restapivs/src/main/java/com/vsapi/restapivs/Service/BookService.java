package com.vsapi.restapivs.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public void update(Book book, int id) {
        bookList = bookList.stream().map(obj -> {
            if (obj.getId() == id) {
                obj.setAuthor(book.getAuthor());
                obj.setTitle(book.getTitle());
            }
            return obj;
        }).collect(Collectors.toList());
    }

}
