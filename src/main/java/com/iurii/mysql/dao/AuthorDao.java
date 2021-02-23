package com.iurii.mysql.dao;

import com.iurii.mysql.POJO.Author;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface AuthorDao {

    int count();
    int insert(Author author);
    Author findById(int id);
    List<Author> findAll();
    int deleteById(int id);
}
