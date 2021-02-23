package com.iurii.mysql.POJO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Book {
    private final long id;
    private final String name;
    private final int yearOfPublishing;
    private final long authorId;
    private final String genre;
}
