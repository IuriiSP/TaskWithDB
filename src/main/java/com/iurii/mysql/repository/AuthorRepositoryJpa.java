package com.iurii.mysql.repository;

import com.iurii.mysql.POJO.Author;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepositoryJpa extends CrudRepository<Author, Long> {

    long count();

    Author save(Author author);

    Author findAuthorById(long id);

    List<Author> findAll();

    void deleteById(long id);

}
