package com.iurii.mysql.repository;

import com.iurii.mysql.POJO.Author;

import java.util.List;

public interface AuthorRepository {

    long count();

    void insert(Author author);

    Author findById(long id);

    List<Author> findAll();

    void deleteById(long id);

}
