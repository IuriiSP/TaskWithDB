package com.iurii.mysql.service;

import com.iurii.mysql.POJO.BookOb;
import com.iurii.mysql.POJO.GenreOb;
import com.iurii.mysql.dao.AuthorDao;
import com.iurii.mysql.POJO.AuthorOb;
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
        authorDao.count();
    }

    @ShellMethod(key = "genreCount", value = "Число жанров")
    public void genreCount() {
        genreDao.count();
    }

    @ShellMethod(key = "bookCount", value = "Число книг")
    public void bookCount() {
        bookDao.count();
    }

    @ShellMethod(key = "authorInsert", value = "добавить элемент в таблицу Авторов")
    public void authorInsert() {
        try  {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int id = Integer.parseInt(reader.readLine());
            String name = reader.readLine();
            int code = Integer.parseInt(reader.readLine());
            AuthorOb authorOb = new AuthorOb(id, name, code);
            authorDao.insert(authorOb);
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
            GenreOb genreOb = new GenreOb(genreId, genre);
            genreDao.insert(genreOb);
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
            BookOb bookOb = new BookOb(idBooks, bookName, yearOFPublishing, autor_id, genre);
            bookDao.insert(bookOb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ShellMethod(key = "authorGetById", value = "Получить автора по id")
    public void authorGetById() {
        try  {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int id = Integer.parseInt(reader.readLine());
            AuthorOb authorOb = authorDao.getById(id);
            System.out.println(authorOb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ShellMethod(key = "genreGetById", value = "Получить жанр по id")
    public void genreGetById() {
        try  {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int id = Integer.parseInt(reader.readLine());
            GenreOb genreOb = genreDao.getById(id);
            System.out.println(genreOb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ShellMethod(key = "bookGetById", value = "Получить книгу по id")
    public void bookGetById() {
        try  {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int id = Integer.parseInt(reader.readLine());
            BookOb bookOb = bookDao.getById(id);
            System.out.println(bookOb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ShellMethod(key = "authorGetAll", value = "получить все записи авторы")
    public void authorGetAll() {
        List<AuthorOb> authors = authorDao.getAll();
        authors.forEach(a -> System.out.println(a.toString()));
    }

    @ShellMethod(key = "genreGetAll", value = "получить все записи жанры")
    public void genreGetAll() {
        List<GenreOb> genres = genreDao.getAll();
        genres.forEach(g -> System.out.println(g.toString()));
    }

    @ShellMethod(key = "bookGetAll", value = "получить все записи Книги")
    public void bookGetAll() {
        List<BookOb> books = bookDao.getAll();
        books.forEach(b -> System.out.println(b.toString()));
    }

    @ShellMethod(key = "authorDeleteById", value = "удалить строку по id из Авторов")
    public void authorDeleteById() {
        try  {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int id = Integer.parseInt(reader.readLine());
            authorDao.deleteById(id);
        } catch (Exception e) {

        }
    }

    @ShellMethod(key = "genreDeleteById", value = "удалить строку по id из Жанров")
    public void genreDeleteById() {
        try  {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int id = Integer.parseInt(reader.readLine());
            genreDao.deleteById(id);
        } catch (Exception e) {

        }
    }

    @ShellMethod(key = "bookDeleteById", value = "удалить строку по id из Книг")
    public void bookDeleteById() {
        try  {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int id = Integer.parseInt(reader.readLine());
            bookDao.deleteById(id);
        } catch (Exception e) {

        }
    }
}
