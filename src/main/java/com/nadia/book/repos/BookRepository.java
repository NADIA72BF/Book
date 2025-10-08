package com.nadia.book.repos;
import com.nadia.book.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import com.nadia.book.entities.books;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource(path = "rest")

public interface BookRepository extends JpaRepository<books,Long> {
    List<books> findByNomBook(String nom);
    List<books> findByNomBookContains(String nom);

    //@Query("select b from books b where b.nomBook like %?1 and b.prixBook > ?2")
    //List<books> findByNomBook (String nom, Double prix);

    @Query("select b from books b where b.nomBook like %:nom and b.prixBook > :prix")
    List<books> findByNomPrix (@Param("nom") String nom, @Param("prix") Double prix);

    @Query("select p from books p where p.type = ?1")
    List<books> findByType (Type type );

    List<books> findByTypeIdT(Long id);

    List<books> findByOrderByNomBookAsc();

    @Query("select b from books b order by b.nomBook ASC, b.prixBook DESC")
    List<books> trierBookNomsPrix ();


}
