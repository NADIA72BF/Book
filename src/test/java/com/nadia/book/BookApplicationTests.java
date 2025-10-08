
package com.nadia.book;
import java.awt.print.Book;
import java.util.Date;
import java.util.List;

import com.nadia.book.entities.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.nadia.book.entities.books;
import com.nadia.book.repos.BookRepository;
@SpringBootTest
class BooksApplicationTests {
    @Autowired
    private BookRepository BookRepository;
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testCreateBook() {
        books b = new books("solitaire",27.7,new Date());
        BookRepository.save(b);
    }
    @Test
    public void testFindBook()
    {
        books b = BookRepository.findById(1L).get();
        System.out.println(b);
    }
    @Test
    public void testUpdateBook()
    {
        books p = BookRepository.findById(1L).get();
        p.setPrixBook(25.0);
        BookRepository.save(p);
    }
    @Test
    public void testDeleteBook()
    {
        BookRepository.deleteById(2L);;
    }
    @Test
    public void testFindAllBooks()
    {
        List<books> bookList = BookRepository.findAll();
        for (books b : bookList)
        {
            System.out.println(b);
        }
    }

    @Test
    public void testFindByNomBook()
    {
        List<books> book = BookRepository.findByNomBook("Something Borrowed");
        for (books b : book) {
            System.out.println(b);
        }
    }

    @Test
    public void testFindByNomBookContains()
    {
        List<books> book = BookRepository.findByNomBookContains("i");
        for (books b : book) {
            System.out.println(b);
        }
    }

    @Test
    public void testFindByNomPrix()
    {
        List<books> book = BookRepository.findByNomPrix("Something Borrowed", 20.9);
        for (books b : book)
        {
            System.out.println(b);
        }
    }

    @Test
    public void testFindByType()
    {
        Type t = new Type();
        t.setIdT(1L);
        List<books> book = BookRepository.findByType(t);
        for (books b : book)
        {
            System.out.println(b);
        }
    }

    @Test
    public void findByTypeIdT()
    {
        List<books> book = BookRepository.findByTypeIdT(1L);
        for (books p : book)
        {
            System.out.println(p);
        }
    }

    @Test
    public void testFindByOrderByNomBookAsc()
    {
        List<books> book =
                BookRepository.findByOrderByNomBookAsc();
        for (books b : book)
        {
            System.out.println(b);
        }
    }

    @Test
    public void testTrierBookNomsPrix()
    {
        List<books> book = BookRepository.trierBookNomsPrix();
        for (books b : book)
        {
            System.out.println(b);
        }
    }




}