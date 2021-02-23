package com.iurii.mysql.POJO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Data
public class Author {
    private final long id;
    private final String name;
    private final long code;
}

