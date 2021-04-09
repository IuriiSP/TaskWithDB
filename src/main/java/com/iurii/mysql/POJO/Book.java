package com.iurii.mysql.POJO;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@Table(name = "books")
public class Book {
    @Id
    private long id;
    private String name;
    private int yearOfPublishing;
    private long authorId;
    private String genre;

    public Book(long id, String name, int yearOfPublishing, long authorId, String genre) {
        this.id = id;
        this.name = name;
        this.yearOfPublishing = yearOfPublishing;
        this.authorId = authorId;
        this.genre = genre;
    }
}
