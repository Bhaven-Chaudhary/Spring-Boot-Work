package com.vsapi.restapivs.Dao;

import com.vsapi.restapivs.Entity.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
    public Book findById(int id);
}
