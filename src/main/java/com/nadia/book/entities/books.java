package com.nadia.book.entities;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBook;
    private String nomBook;
    private Double prixBook;
    private Date dateBook;

    @ManyToOne //crée une clé étrangère (IdT) dans la table book
    private Type type;

    public books() {
        super();
    }

    public books( String nomBook, Double prixBook, Date dateBook) {
        super();
        this.nomBook = nomBook;
        this.prixBook = prixBook;
        this.dateBook = dateBook;
    }

    public Long getIdBook() {
        return idBook;
    }
    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }
    public String getNomBook() {
        return nomBook;
    }
    public void setNomBook(String nomBook) {
        this.nomBook = nomBook;
    }
    public Double getPrixBook() {
        return prixBook;
    }
    public void setPrixBook(Double prixBook) {
        this.prixBook = prixBook;
    }
    public Date getDateBook() {
        return dateBook;
    }

    public void setDateBook(Date dateBook) {
        this.dateBook = dateBook;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String toString() {
        return "Books{" +
                "idBook=" + idBook +
                ", nomBook='" + nomBook + '\'' +
                ", prixBook=" + prixBook +
                ", dateBook=" + dateBook +
                '}';
    }

}
