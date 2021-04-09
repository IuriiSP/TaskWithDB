package com.iurii.mysql.repository;

import com.iurii.mysql.POJO.Comment;

import java.util.List;

public interface CommentRepository {

    long count();

    void insert(Comment comment);

    Comment findById(long id);

    List<Comment> findAll();

    void deleteById(long id);
}
