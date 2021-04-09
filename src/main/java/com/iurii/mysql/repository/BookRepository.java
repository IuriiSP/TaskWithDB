package com.iurii.mysql.repository;

import com.iurii.mysql.POJO.Book;

import java.util.List;

public interface BookRepository {
    long count();

    void insert(Book book);

    Book findById(long id);

    List<Book> findAll();

    void deleteById(long id);
}
