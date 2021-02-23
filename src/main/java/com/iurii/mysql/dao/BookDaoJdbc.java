package com.iurii.mysql.dao;

import com.iurii.mysql.POJO.Book;
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
    public int count() {
        return operations.queryForObject("select count(*) from books", Integer.class);
    }

    @Override
    public int insert(Book book) {
        return operations.update("insert into books (idBooks, `BookName`, yearOfPublishing, authorId, `genre`) values (?,?,?,?,?)",
                book.getId(), book.getName(), book.getYearOfPublishing(), book.getAuthorId(), book.getGenre());
    }

    @Override
    public Book findById(int id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return namedOperations.queryForObject("select * from books where idBooks = :id", params, new BookDaoJdbc.BookMapper());
    }

    @Override
    public List<Book> findAll() {
        return namedOperations.query("select * from books", new BookDaoJdbc.BookMapper());
    }

    @Override
    public int deleteById(int id) {
        Map<String, Object>params = Collections.singletonMap("id", id);
        return namedOperations.update("delete from books where idBooks = :id", params);
    }

    public static class BookMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("idBooks");
            String name = resultSet.getString("BookName");
            int yearOfPublishing = resultSet.getInt("yearOfPublishing");
            int author_id = resultSet.getInt("authorId");
            String genre = resultSet.getString("genre");
            return new Book(id, name, yearOfPublishing, author_id, genre);
        }
    }
}
