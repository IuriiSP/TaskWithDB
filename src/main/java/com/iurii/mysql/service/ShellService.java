package com.iurii.mysql.service;

import com.iurii.mysql.POJO.Book;
import com.iurii.mysql.POJO.Comment;
import com.iurii.mysql.POJO.Genre;
import com.iurii.mysql.POJO.Author;

import com.iurii.mysql.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class ShellService {

    private final GenreRepositoryJpa genreRepositoryJpa;
    private final CommentRepositoryJpa commentRepositoryJpa;
    private final AuthorRepositoryJpa authorRepositoryJpa;
    private final BookRepositoryJpa bookRepositoryJpa;

    /**
     * сервис для работы с таблицей Авторов
     */
    @ShellMethod(key = "authorCount", value = "число авторов")
    public void authorCount() {
        long count = authorRepositoryJpa.count();
        System.out.println("Число авторов в БД: " + count);
    }

    @ShellMethod(key = "authorInsert", value = "добавить элемент в таблицу Авторов")
    public void authorInsert() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int id = Integer.parseInt(reader.readLine());
            String name = reader.readLine();
            int code = Integer.parseInt(reader.readLine());
            Author author = new Author(id, name, code);
            authorRepositoryJpa.save(author);
            System.out.println("Добавлен автор " + author.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ShellMethod(key = "authorFindById", value = "Получить автора по id")
    public void authorGetById() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            long id = Integer.parseInt(reader.readLine());
            Author author = authorRepositoryJpa.findAuthorById(id);
            System.out.println(author.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ShellMethod(key = "authorFindAll", value = "получить все записи авторы")
    public void authorGetAll() {
        List<Author> authors = authorRepositoryJpa.findAll();
        authors.forEach(a -> System.out.println(a.toString()));
    }

    @ShellMethod(key = "authorDeleteById", value = "Удалить автора с заданным id")
    public void authorDeleteById() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            long id = Integer.parseInt(reader.readLine());
            authorRepositoryJpa.deleteById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * сервис для работы с таблицей жанров
     */
    @ShellMethod(key = "genreCount", value = "число жанров")
    public void genreCount() {
        long count = genreRepositoryJpa.count();
        System.out.println("Число жанров в БД: " + count);
    }

    @ShellMethod(key = "genreInsert", value = "добавить элемент в таблицу Жанров")
    public void genreInsert() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int id = Integer.parseInt(reader.readLine());
            String name = reader.readLine();
            Genre genre = new Genre(id, name);
            genreRepositoryJpa.save(genre);
            System.out.println("Добавлен жанр " + genre.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ShellMethod(key = "genreFindById", value = "Получить автора по id")
    public void genreGetById() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            long id = Integer.parseInt(reader.readLine());
            Genre genre = genreRepositoryJpa.findById(id);
            System.out.println(genre.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ShellMethod(key = "genreFindAll", value = "получить все записи жанры")
    public void genreGetAll() {
        List<Genre> genres = genreRepositoryJpa.findAll();
        genres.forEach(a -> System.out.println(a.toString()));
    }

    @ShellMethod(key = "genreDeleteById", value = "Удалить жанр с заданным id")
    public void genreDeleteById() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            long id = Integer.parseInt(reader.readLine());
            genreRepositoryJpa.deleteById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * сервис для работы с таблицей комментариев
     */
    @ShellMethod(key = "commentCount", value = "число комментариев")
    public void commentCount() {
        long count = commentRepositoryJpa.count();
        System.out.println("Число комментариев в БД: " + count);
    }

    @ShellMethod(key = "commentInsert", value = "добавить элемент в таблицу Комментариев")
    public void commentInsert() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int id = Integer.parseInt(reader.readLine());
            int bookId = Integer.parseInt(reader.readLine());
            String commentStr = reader.readLine();
            Comment comment = new Comment(id, bookId, commentStr);
            commentRepositoryJpa.save(comment);
            System.out.println("Добавлен комментарий " + comment.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ShellMethod(key = "commentFindById", value = "Получить комментарий по id")
    public void commentFindById() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            long id = Integer.parseInt(reader.readLine());
            Comment comment = commentRepositoryJpa.findById(id);
            System.out.println(comment.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ShellMethod(key = "commentFindAll", value = "получить все записи комментарии")
    public void commentGetAll() {
        List<Comment> comments = commentRepositoryJpa.findAll();
        comments.forEach(a -> System.out.println(a.toString()));
    }

    @ShellMethod(key = "commentDeleteById", value = "Удалить комментарий с заданным id")
    public void commentDeleteById() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            long id = Integer.parseInt(reader.readLine());
            commentRepositoryJpa.deleteById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * сервис для работы с таблицей книг
     */
    @ShellMethod(key = "bookCount", value = "число книг")
    public void bookCount() {
        long count = bookRepositoryJpa.count();
        System.out.println("Число книг в БД: " + count);
    }

    @ShellMethod(key = "bookInsert", value = "добавить элемент в таблицу Книг")
    public void bookInsert() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            long id = Integer.parseInt(reader.readLine());
            String name = reader.readLine();
            int yearOfPublishing = Integer.parseInt(reader.readLine());
            long authorId = Integer.parseInt(reader.readLine());
            String genre = reader.readLine();
            Book book = new Book(id, name, yearOfPublishing, authorId, genre);
            bookRepositoryJpa.save(book);
            System.out.println("Добавлена книга " + book.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ShellMethod(key = "bookFindById", value = "Получить книгу по id")
    public void bookFindById() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            long id = Integer.parseInt(reader.readLine());
            Book book = bookRepositoryJpa.findById(id);
            System.out.println(book.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ShellMethod(key = "bookFindAll", value = "получить все записи комментарии")
    public void bookGetAll() {
        List<Book> books = bookRepositoryJpa.findAll();
        books.forEach(a -> System.out.println(a.toString()));
    }

    @ShellMethod(key = "bookDeleteById", value = "Удалить книгу с заданным id")
    public void bookDeleteById() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            long id = Integer.parseInt(reader.readLine());
            bookRepositoryJpa.deleteById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
