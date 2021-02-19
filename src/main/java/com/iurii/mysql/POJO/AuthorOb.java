package com.iurii.mysql.POJO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Data
public class AuthorOb {
    private final int id;
    private final String name;
    private final int code;
}

