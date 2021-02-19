package com.iurii.mysql.dao;

import com.iurii.mysql.POJO.GenreOb;
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
public class GenreDaoJdbc implements GenreDao {
    private final JdbcOperations operations;
    private final NamedParameterJdbcOperations namedOperations;
    @Override
    public void count() {
        int count = operations.queryForObject("select count(*) from genres", Integer.class);
        System.out.println(count);
    }

    @Override
    public void insert(GenreOb genreOb) {
        operations.update("insert into genres (genreId, `Genre`) values (?,?)", genreOb.getGenreId(), genreOb.getGenre());
    }

    @Override
    public GenreOb getById(int id) {

        Map<String, Object> params = Collections.singletonMap("id", id);
        return namedOperations.queryForObject("select * from genres where genreId = :id", params, new GenreDaoJdbc.GenreMapper());
    }

    @Override
    public List<GenreOb> getAll() {
        return namedOperations.query("select * from genres", new GenreDaoJdbc.GenreMapper());
    }

    @Override
    public void deleteById(int id) {
        Map<String, Object>params = Collections.singletonMap("id", id);
        namedOperations.update("delete from genres where genreId = :id", params);
    }
    public static class GenreMapper implements RowMapper<GenreOb> {
        @Override
        public GenreOb mapRow(ResultSet resultSet, int i) throws SQLException {
            int genre_id = resultSet.getInt("genreId");
            String genre = resultSet.getString("Genre");
            return new GenreOb(genre_id, genre);
        }
    }
}
