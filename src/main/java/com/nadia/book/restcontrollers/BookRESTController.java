package com.nadia.book.restcontrollers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.nadia.book.entities.books;
import com.nadia.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class BookRESTController {
    @Autowired
    BookService bookService ;
    @RequestMapping(path="all" ,method = RequestMethod.GET)
    public List<books> getAllBooks (){
        return bookService.getAllBooks();
    }
    @RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
    //@GetMapping("/getbyid/{id}")
    public books getBookById(@PathVariable("id") Long id) {
        return bookService.getBook(id);
    }

    //@RequestMapping(value="/addprod" ,method = RequestMethod.POST)
    @PostMapping("/addbook")

    public books createBook(@RequestBody books book) {
        return bookService.saveBook(book);
    }
    //@RequestMapping(value="/updateprod" ,method = RequestMethod.PUT)
    @PutMapping("/updatebook")
    @PreAuthorize("hasAuthority('ADMIN')")
    public books updateBook(@RequestBody books book) {
        return bookService.updateBook(book);
    }
    @RequestMapping(value="/delbook/{id}",method = RequestMethod.DELETE)
    @DeleteMapping("/delprod/{id}" )
    public void deleteBook(@PathVariable("id") Long id)
    {
        bookService.deleteBookById( id);
    }
    @RequestMapping(value="/bookType/{idT}",method = RequestMethod.GET)
    public List<books> getBookByTypeId(@PathVariable("idT") Long idT) {
        return bookService.findByTypeIdT(idT);
    }
    @RequestMapping(value="/booksByName/{nom}",method = RequestMethod.GET)
    public List<books> findByNomBookContains(@PathVariable("nom") String nom) {
        return bookService.findByNomBookContains(nom);
    }

}
