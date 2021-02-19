package com.iurii.mysql.dao;

import com.iurii.mysql.POJO.BookOb;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class BookDaoJdbc implements BookDao {
    private final JdbcOperations operations;
    private final NamedParameterJdbcOperations namedOperations;
    @Override
    public void count() {
        int count = operations.queryForObject("select count(*) from books", Integer.class);
        System.out.println(count);
    }

    @Override
    public void insert(BookOb bookOb) {
        operations.update("insert into books (idBooks, `BookName`, yearOfPublishing, authorId, `genre`) values (?,?,?,?,?)",
                bookOb.getIdBook(), bookOb.getBookName(), bookOb.getYearOfPublishing(), bookOb.getAuthorId(), bookOb.getGenre());
    }

    @Override
    public BookOb getById(int id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return namedOperations.queryForObject("select * from books where idBooks = :id", params, new BookDaoJdbc.BookMapper());
    }

    @Override
    public List<BookOb> getAll() {
        return namedOperations.query("select * from books", new BookDaoJdbc.BookMapper());
    }

    @Override
    public void deleteById(int id) {
        Map<String, Object>params = Collections.singletonMap("id", id);
        namedOperations.update("delete from books where idBooks = :id", params);
    }

    public static class BookMapper implements RowMapper<BookOb> {
        @Override
        public BookOb mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("idBooks");
            String name = resultSet.getString("Book Name");
            int yearOfPublishing = resultSet.getInt("year of publishing");
            int author_id = resultSet.getInt("authorId");
            String genre = resultSet.getString("genre");
            return new BookOb(id, name, yearOfPublishing, author_id, genre);
        }
    }
}
