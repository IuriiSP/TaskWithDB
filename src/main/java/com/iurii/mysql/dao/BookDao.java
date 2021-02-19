package com.iurii.mysql.dao;

import com.iurii.mysql.POJO.BookOb;

import java.util.List;

public interface BookDao {
    void count();
    void insert(BookOb bookOb);
    BookOb getById(int id);
    List<BookOb> getAll();
    void deleteById(int id);
}
