package com.nadia.book.entities;

import org.springframework.data.rest.core.config.Projection;


@Projection(name="nomBook" , types = books.class)
public interface BookProjection {
    public String getNomBook();
}