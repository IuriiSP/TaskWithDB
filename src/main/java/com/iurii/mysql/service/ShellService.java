package com.iurii.mysql.service;

import com.iurii.mysql.dao.AuthorDao;
import com.iurii.mysql.domain.AuthorOb;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@ShellComponent
public class ShellService {
    private final AuthorDao authorDao;

    public ShellService(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @ShellMethod(key = "count", value = "SQL count")
    public void count() {
        authorDao.count();
    }

    @ShellMethod(key = "insert", value = "добавить элемент в таблицу")
    public void insert() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int id = Integer.parseInt(reader.readLine());
            String name = reader.readLine();
            int code = Integer.parseInt(reader.readLine());
            AuthorOb authorOb = new AuthorOb(id, name, code);
            authorDao.insert(authorOb);
        } catch (Exception e) {

        }
    }

    @ShellMethod(key = "getById", value = "Получить элемент по id")
    public void getById(){
        try  {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int id = Integer.parseInt(reader.readLine());
            AuthorOb authorOb = authorDao.getById(id);
            System.out.println(authorOb.getId() + " " + authorOb.getName() + " " + authorOb.getCode());
        } catch (Exception e) {

        }
    }

    @ShellMethod(key = "getAll", value = "получить все записи")
    public void getAll(){
        List<AuthorOb> authors = authorDao.getAll();
        authors.forEach(authorOb -> System.out.println(authorOb.getId() + " " + authorOb.getName() + " " + authorOb.getCode()));
    }

    @ShellMethod(key = "deleteById", value = "удалить строку по id")
    public void deleteById(){
        try  {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int id = Integer.parseInt(reader.readLine());
            authorDao.deleteById(id);
        } catch (Exception e) {

        }
    }
}
