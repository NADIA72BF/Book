package com.nadia.book.restcontrollers;

import com.nadia.book.entities.Type;
import com.nadia.book.repos.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/api/t")
@CrossOrigin()
public class TypeRESTController {
    @Autowired
    TypeRepository typeRepository;
    @RequestMapping(method= RequestMethod.GET)
    public List<Type> getAllCategories()
    {
        return typeRepository.findAll();
    }
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Type getTypeById(@PathVariable("id") Long id) {
        return typeRepository.findById(id).get();
    }


}
