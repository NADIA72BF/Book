package com.nadia.book.restcontrollers;

import com.nadia.book.entities.books;
import com.nadia.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class BookRESTController {
    @Autowired
    BookService bookService ;
    @RequestMapping(method = RequestMethod.GET)
    public List<books> getAllBooks (){
        return bookService.getAllBooks();
    }
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public books getBookById(@PathVariable("id") Long id) {
        return bookService.getBook(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public books createBook(@RequestBody books book) {
        return bookService.saveBook(book);
    }
    @RequestMapping(method = RequestMethod.PUT)
    public books updateBook(@RequestBody books book) {
        return bookService.updateBook(book);
    }
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable("id") Long id)
    {
        bookService.deleteBookById( id);
    }
    @RequestMapping(value="/BookType/{idCat}",method = RequestMethod.GET)
    public List<books> getBookByTypeId(@PathVariable("idCat") Long idCat) {
        return bookService.findByTypeIdT(idCat);
    }

}
