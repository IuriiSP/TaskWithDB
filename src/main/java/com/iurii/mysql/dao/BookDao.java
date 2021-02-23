package com.iurii.mysql.dao;

import com.iurii.mysql.POJO.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface BookDao {
    int count();
    int insert(Book book);
    Book findById(int id);
    List<Book> findAll();
    int deleteById(int id);
}
