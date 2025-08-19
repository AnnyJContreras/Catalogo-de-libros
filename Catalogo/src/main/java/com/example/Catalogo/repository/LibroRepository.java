package com.example.Catalogo.repository;

import com.example.Catalogo.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    // Buscar libro por título exacto
    Optional<Libro> findByTituloIgnoreCase(String titulo);

    // Buscar libros por idioma
    @Query("SELECT l FROM libro l WHERE l.idioma = :idioma")
    List<Libro> findByIdioma(@Param("idioma") String idioma);


}




