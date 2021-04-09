package com.iurii.mysql.repository;

import com.iurii.mysql.POJO.Book;
import com.iurii.mysql.POJO.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BookRepositoryJpa implements BookRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public long count() {
        TypedQuery<Long> query = em.createQuery("select count (e) from Book e", Long.class);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void insert(Book book) {
        em.persist(book);
    }

    @Override
    public Book findById(long id) {
        TypedQuery<Book> query = em.createQuery("select e from Book e where e.id = :id", Book.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Book> findAll() {
        TypedQuery<Book> query = em.createQuery("select e from Book e", Book.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        Book book = em.find(Book.class, id);
        em.remove(book);
    }
}
