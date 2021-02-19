package com.iurii.mysql.dao;

import com.iurii.mysql.POJO.AuthorOb;
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
    public void count() {
        int count = operations.queryForObject("select count(*) from authors", Integer.class);
        System.out.println(count);
    }


    @Override
    public void insert(AuthorOb authorOb) {
            operations.update("insert into authors (id, `name`, code) values (?,?,?)", authorOb.getId(),
                    authorOb.getName(), authorOb.getCode());
    }

    @Override
    public AuthorOb getById(int id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return namedOperations.queryForObject("select * from authors where id = :id", params, new AuthorMapper());
    }

    @Override
    public List<AuthorOb> getAll() {
        return namedOperations.query("select * from authors", new AuthorMapper());
    }

    @Override
    public void deleteById(int id) {
        Map<String, Object>params = Collections.singletonMap("id", id);
        namedOperations.update("delete from authors where id = :id", params);
    }

    public static class AuthorMapper implements RowMapper<AuthorOb>{
        @Override
        public AuthorOb mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int code = resultSet.getInt("code");
            return new AuthorOb(id, name, code);
        }
    }
}
