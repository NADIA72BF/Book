package com.nadia.book.service;
import com.nadia.book.entities.Type;
import com.nadia.book.entities.books;
import com.nadia.book.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    //@PreAuthorize("hasAuthority('ADMIN')")
    @Override
    public books saveBook(books b) {
        return bookRepository.save(b);
    }

    @Override
    public books updateBook(books b) {
        return bookRepository.save(b);
    }

    @Override
    public void deleteBook(books b) {
        bookRepository.delete(b);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public books getBook(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public List<books> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<books> findByNomBook(String nom) {
        return bookRepository.findByNomBook(nom);
    }

    @Override
    public List<books> findByNomBookContains(String nom) {
        return bookRepository.findByNomBookContains(nom);
    }

    @Override
    public List<books> findByNomPrix(String nom, Double prix) {
        return bookRepository.findByNomPrix(nom, prix);
    }

    @Override
    public List<books> findByType(Type type) {
        return bookRepository.findByType(type);
    }


    @Override
    public List<books> findByTypeIdT(Long id) {
        return bookRepository.findByTypeIdT(id);
    }

    @Override
    public List<books> findByOrderByNomBookAsc() {
        return bookRepository.findByOrderByNomBookAsc();
    }

    @Override
    public List<books> trierBookNomsPrix() {
        return bookRepository.findByOrderByNomBookAsc();
    }
}
