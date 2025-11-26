package com.nadia.book.repos;

import com.nadia.book.entities.Type;
import com.nadia.book.entities.books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path = "t")
@CrossOrigin("http://localhost:4200/") //pour autoriser angular
public interface TypeRepository extends JpaRepository <Type, Long>
{
}
