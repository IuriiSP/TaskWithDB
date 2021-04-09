package com.iurii.mysql.repository;

import com.iurii.mysql.POJO.Author;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository

public class AuthorRepositoryJpa implements AuthorRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public long count() {
        TypedQuery<Long> query = em.createQuery(
                "select count (e) from Author e",
                Long.class
        );
        return query.getSingleResult();
    }

// Пока не получается
    @Override
    @Transactional
    public void insert(Author author) {
        em.persist(author);
    }

    @Override
    public Author findById(long id) {
       TypedQuery<Author> query = em.createQuery("select e from Author e where e.id = :id", Author.class);
       query.setParameter("id", id);
       return query.getSingleResult();
    }

    @Override
    public List<Author> findAll() {
        TypedQuery<Author> query = em.createQuery("select e from Author e", Author.class);
        return query.getResultList();
    }
//Пока не трогал, навереное реализуется по аналогии с добавлением
    @Override
    @Transactional
    public void deleteById(long id) {
        Author author = em.find(Author.class, id);
        em.remove(author);
    }
}
