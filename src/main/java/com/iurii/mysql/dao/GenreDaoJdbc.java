package com.iurii.mysql.dao;

import com.iurii.mysql.POJO.Genre;
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
    public int count() {
        return operations.queryForObject("select count(*) from genres", Integer.class);
    }

    @Override
    public int insert(Genre genre) {
        return operations.update("insert into genres (genreId, `Genre`) values (?,?)", genre.getId(), genre.getGenre());
    }

    @Override
    public Genre findById(int id) {

        Map<String, Object> params = Collections.singletonMap("id", id);
        return namedOperations.queryForObject("select * from genres where genreId = :id", params, new GenreDaoJdbc.GenreMapper());
    }

    @Override
    public List<Genre> findAll() {
        return namedOperations.query("select * from genres", new GenreDaoJdbc.GenreMapper());
    }

    @Override
    public int deleteById(int id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return namedOperations.update("delete from genres where genreId = :id", params);
    }

    public static class GenreMapper implements RowMapper<Genre> {
        @Override
        public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
            int genre_id = resultSet.getInt("genreId");
            String genre = resultSet.getString("genre");
            return new Genre(genre_id, genre);
        }
    }
}
