package com.iurii.mysql.dao;

import com.iurii.mysql.POJO.Genre;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface GenreDao {
    int count();
    int insert(Genre genre);
    Genre findById(int id);
    List<Genre> findAll();
    int deleteById(int id);
}
