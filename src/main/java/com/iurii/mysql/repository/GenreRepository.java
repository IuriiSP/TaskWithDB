package com.iurii.mysql.repository;

import com.iurii.mysql.POJO.Author;
import com.iurii.mysql.POJO.Genre;

import java.util.List;

public interface GenreRepository {

    long count();

    void insert(Genre genre);

    Genre findById(long id);

    List<Genre> findAll();

    void deleteById(long id);
}
