package com.iurii.mysql.POJO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "authors")

public class Author {
    @Id
    private long id;
    private String name;
    private long code;

    public Author(long id, String name, long code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    @Override
    public String toString() {
        return (this.getId() + " " + this.getName() + " " + this.getCode());
    }
}

