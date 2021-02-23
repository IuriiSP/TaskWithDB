package com.iurii.mysql.dao;

import com.iurii.mysql.POJO.Author;
import lombok.Data;
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
@Data
public class AuthorDaoJdbc implements AuthorDao {

    private final JdbcOperations operations;
    private final NamedParameterJdbcOperations namedOperations;

    @Override
    public int count() {
        return operations.queryForObject("select count(*) from authors", Integer.class);
    }


    @Override
    public int insert(Author author) {
            return operations.update("insert into authors (id, `name`, code) values (?,?,?)", author.getId(),
                    author.getName(), author.getCode());
    }

    @Override
    public Author findById(int id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return namedOperations.queryForObject("select * from authors where id = :id", params, new AuthorMapper());
    }

    @Override
    public List<Author> findAll() {
        return namedOperations.query("select * from authors", new AuthorMapper());
    }

    @Override
    public int deleteById(int id) {
        int numberOfRows;
        Map<String, Object>params = Collections.singletonMap("id", id);
        return namedOperations.update("delete from authors where id = :id", params);
    }

    public static class AuthorMapper implements RowMapper<Author>{
        @Override
        public Author mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int code = resultSet.getInt("code");
            return new Author(id, name, code);
        }
    }
}
