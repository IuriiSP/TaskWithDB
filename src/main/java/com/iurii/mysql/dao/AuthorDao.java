package com.iurii.mysql.dao;

import com.iurii.mysql.POJO.AuthorOb;

import java.util.List;

public interface AuthorDao {

    void count();
    void insert(AuthorOb authorOb);
    AuthorOb getById(int id);
    List<AuthorOb>getAll();
    void deleteById(int id);
}
