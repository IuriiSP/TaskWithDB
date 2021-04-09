package com.iurii.mysql.POJO;

import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Transactional
@Table(name = "genres")
public class Genre {
    @Id
    private long id;

    private String genre;

    public Genre(long id, String genre) {
        this.id = id;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return (this.getId() + " " + this.getGenre());
    }
}
