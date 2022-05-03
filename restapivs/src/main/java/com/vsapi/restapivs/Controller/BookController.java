package com.vsapi.restapivs.Controller;

import java.util.List;

import com.vsapi.restapivs.Entity.Book;
import com.vsapi.restapivs.Service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    BookService bookService = new BookService();

    // sending data to client i.e Get operatin (Read)
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllbooks() {

        List<Book> allBook = bookService.getAllBook();

        if (allBook.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(allBook);
        }

    }

    // sending data to client i.e Get operatin (Read)
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
        try {
            Book book = bookService.getBook(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(book);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Getting data from client to add i.e Post operation (Create)
    @PostMapping("/books")
    public ResponseEntity<String> addBook(@RequestBody Book book) {

        try {
            bookService.addBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    // Sending Delete request from the client i.e Delete operation
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) {
        try {
            bookService.deleteBook(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    // Sending data from client to perform PUT operation i.e Update
    @PutMapping("/books/{id}")
    public ResponseEntity<Void> update(@RequestBody Book book, @PathVariable("id") int id) {

        try {
            bookService.update(book, id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}
