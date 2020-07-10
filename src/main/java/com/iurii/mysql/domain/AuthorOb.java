package com.iurii.mysql.domain;

public class AuthorOb {
    private final int id;
    private final String name;
    private final int code;

    public AuthorOb(int id, String name, int code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }
}
