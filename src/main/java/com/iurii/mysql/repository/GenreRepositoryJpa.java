package com.iurii.mysql.repository;

import com.iurii.mysql.POJO.Genre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GenreRepositoryJpa extends CrudRepository<Genre, Long> {

    long count();

    Genre save(Genre genre);

    Genre findById(long id);

    List<Genre> findAll();

    void deleteById(long id);
}
