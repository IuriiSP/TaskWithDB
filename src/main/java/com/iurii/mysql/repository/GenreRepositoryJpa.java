package com.iurii.mysql.repository;

import com.iurii.mysql.POJO.Author;
import com.iurii.mysql.POJO.Genre;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class GenreRepositoryJpa implements GenreRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public long count() {
        TypedQuery<Long> query = em.createQuery(
                "select count (e) from Genre e",
                Long.class
        );
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void insert(Genre genre) {
        em.persist(genre);
    }

    @Override
    public Genre findById(long id) {
        TypedQuery<Genre> query = em.createQuery("select e from Genre e where e.id = :id", Genre.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Genre> findAll() {
        TypedQuery<Genre> query = em.createQuery("select e from Genre e", Genre.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        Genre genre = em.find(Genre.class, id);
        em.remove(genre);
    }
}
