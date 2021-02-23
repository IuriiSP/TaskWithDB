package com.iurii.mysql.service;

import com.iurii.mysql.POJO.Book;
import com.iurii.mysql.POJO.Genre;
import com.iurii.mysql.dao.AuthorDao;
import com.iurii.mysql.POJO.Author;
import com.iurii.mysql.dao.BookDao;
import com.iurii.mysql.dao.GenreDao;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class ShellService {
    private final AuthorDao authorDao;
    private final GenreDao genreDao;
    private final BookDao bookDao;

    @ShellMethod(key = "authorCount", value = "число авторов")
    public void authorCount() {
        System.out.println("число авторов: " + authorDao.count());
    }

    @ShellMethod(key = "genreCount", value = "Число жанров")
    public void genreCount() {
        System.out.println("Число жанров:" + genreDao.count());
    }

    @ShellMethod(key = "bookCount", value = "Число книг")
    public void bookCount() {
        System.out.println("Число книг:" + bookDao.count());
    }

    @ShellMethod(key = "authorInsert", value = "добавить элемент в таблицу Авторов")
    public void authorInsert() {
        try  {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int id = Integer.parseInt(reader.readLine());
            String name = reader.readLine();
            int code = Integer.parseInt(reader.readLine());
            Author author = new Author(id, name, code);
            int numberOfRows = authorDao.insert(author);
            System.out.println("Операция затронула строк: " + numberOfRows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ShellMethod(key = "genreInsert", value = "добавить элемент в таблицу Жанров")
    public void genreInsert() {
        try  {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int genreId = Integer.parseInt(reader.readLine());
            String genre = reader.readLine();
            Genre genreOb = new Genre(genreId, genre);
            int numberOfRows = genreDao.insert(genreOb);
            System.out.println("Операция затронула строк: " + numberOfRows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ShellMethod(key = "bookInsert", value = "добавить элемент в таблицу Книги")
    public void bookInsert() {
        try  {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int idBooks = Integer.parseInt(reader.readLine());
            String bookName = reader.readLine();
            int yearOFPublishing = Integer.parseInt(reader.readLine());
            int autor_id = Integer.parseInt(reader.readLine());
            String genre = reader.readLine();
            Book book = new Book(idBooks, bookName, yearOFPublishing, autor_id, genre);
            int numberOfRows = bookDao.insert(book);
            System.out.println("Операция затронула строк: " + numberOfRows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ShellMethod(key = "authorFindById", value = "Получить автора по id")
    public void authorGetById() {
        try  {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int id = Integer.parseInt(reader.readLine());
            Author author = authorDao.findById(id);
            System.out.println(author.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ShellMethod(key = "genreFindById", value = "Получить жанр по id")
    public void genreGetById() {
        try  {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int id = Integer.parseInt(reader.readLine());
            Genre genre = genreDao.findById(id);
            System.out.println(genre.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ShellMethod(key = "bookFindById", value = "Получить книгу по id")
    public void bookGetById() {
        try  {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int id = Integer.parseInt(reader.readLine());
            Book book = bookDao.findById(id);
            System.out.println(book.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ShellMethod(key = "authorFindAll", value = "получить все записи авторы")
    public void authorGetAll() {
        List<Author> authors = authorDao.findAll();
        authors.forEach(a -> System.out.println(a.toString()));
    }

    @ShellMethod(key = "genreFindAll", value = "получить все записи жанры")
    public void genreGetAll() {
        List<Genre> genres = genreDao.findAll();
        genres.forEach(g -> System.out.println(g.toString()));
    }

    @ShellMethod(key = "bookFindAll", value = "получить все записи Книги")
    public void bookGetAll() {
        List<Book> books = bookDao.findAll();
        books.forEach(b -> System.out.println(b.toString()));
    }

    @ShellMethod(key = "authorDeleteById", value = "удалить строку по id из Авторов")
    public void authorDeleteById() {
        try  {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int id = Integer.parseInt(reader.readLine());
            int numberOfRows = authorDao.deleteById(id);
            System.out.println("Операция затронула строк: " + numberOfRows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ShellMethod(key = "genreDeleteById", value = "удалить строку по id из Жанров")
    public void genreDeleteById() {
        try  {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int id = Integer.parseInt(reader.readLine());
            int numberOfRows = genreDao.deleteById(id);
            System.out.println("Операция затронула строк: " + numberOfRows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ShellMethod(key = "bookDeleteById", value = "удалить строку по id из Книг")
    public void bookDeleteById() {
        try  {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int id = Integer.parseInt(reader.readLine());
            int numberOfRows = bookDao.deleteById(id);
            System.out.println("Операция затронула строк: " + numberOfRows);
        } catch (Exception e) {

        }
    }
}
