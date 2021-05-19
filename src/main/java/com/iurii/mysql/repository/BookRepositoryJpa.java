package com.iurii.mysql.repository;

import com.iurii.mysql.POJO.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepositoryJpa extends CrudRepository<Book, Long> {

    long count();

    Book save(Book book);

    Book findById(long id);

    List<Book> findAll();

    void deleteById(long id);
}
