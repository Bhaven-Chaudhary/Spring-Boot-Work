package com.vsapi.restapivs.Controller;

import java.util.List;

import com.vsapi.restapivs.Entity.Book;
import com.vsapi.restapivs.Service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    BookService bookService = new BookService();

    // sending data to client i.e Get operatin (Read)
    @GetMapping("/books")
    public List<Book> book() {
        List<Book> allBook = bookService.getAllBook();
        return allBook;
    }

    // Getting data from client to add i.e Post operation (Create)
    @PostMapping("/books")
    public String addBook(@RequestBody Book book) {
        boolean addedBook = bookService.addBook(book);
        if (addedBook) {
            return "New Book Added";
        }
        return "Book Not Added";
    }

    // Sending Delete request from the client i.e Delete operation
    @DeleteMapping("/books/{id}")
    public Book deleteBook(@PathVariable("id") int id) {
        Book book = bookService.deleteBook(id);
        return book;
    }

}
