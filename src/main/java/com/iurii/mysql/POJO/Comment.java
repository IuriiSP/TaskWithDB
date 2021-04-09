package com.iurii.mysql.POJO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "comments")
public class Comment {
    @Id
    private long id;
    //@OneToOne
    //@JoinColumn(name = "bookId")
    private long bookId;
    private String comment;

    public Comment(long id, long bookId, String comment) {
        this.id = id;
        this.bookId = bookId;
        this.comment = comment;
    }
}
