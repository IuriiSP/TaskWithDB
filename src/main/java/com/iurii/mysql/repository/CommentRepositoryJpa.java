package com.iurii.mysql.repository;

import com.iurii.mysql.POJO.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepositoryJpa extends CrudRepository<Comment, Long> {

    long count();

    Comment save (Comment comment);

    Comment findById(long id);

    List<Comment> findAll();

    void deleteById(long id);
}
