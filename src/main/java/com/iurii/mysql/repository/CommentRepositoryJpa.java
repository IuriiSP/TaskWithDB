package com.iurii.mysql.repository;

import com.iurii.mysql.POJO.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CommentRepositoryJpa implements CommentRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public long count() {
        TypedQuery<Long> query = em.createQuery("select count(e) from Comment e", Long.class);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void insert(Comment comment) {
        em.persist(comment);
    }

    @Override
    public Comment findById(long id) {
        TypedQuery<Comment> query = em.createQuery("select e from Comment e where e.id = :id", Comment.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Comment> findAll() {
        TypedQuery<Comment> query = em.createQuery("select e from Comment e", Comment.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        Comment comment = em.find(Comment.class, id);
        em.remove(comment);
    }
}
