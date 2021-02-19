package com.iurii.mysql.dao;

import com.iurii.mysql.POJO.GenreOb;

import java.util.List;

public interface GenreDao {
    void count();
    void insert(GenreOb genreOb);
    GenreOb getById(int id);
    List<GenreOb> getAll();
    void deleteById(int id);
}
