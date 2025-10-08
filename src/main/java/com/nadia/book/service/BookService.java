package com.nadia.book.service;

import com.nadia.book.entities.Type;
import com.nadia.book.entities.books;
import java.util.List;


public interface BookService {
    books saveBook(books b);
    books updateBook(books b);
    void deleteBook(books b);
    void deleteBookById(Long id);
    books getBook(Long id);
    List<books> getAllBooks();
    List<books> findByNomBook(String nom);
    List<books> findByNomBookContains(String nom);
    List<books> findByNomPrix (String nom, Double prix);
    List<books> findByType (Type type);
    List<books> findByTypeIdT(Long id);
    List<books> findByOrderByNomBookAsc();
    List<books> trierBookNomsPrix();
}
