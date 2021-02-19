package com.iurii.mysql.POJO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class BookOb {
    private final int idBook;
    private final String bookName;
    private final int yearOfPublishing;
    private final int authorId;
    private final String genre;
}
