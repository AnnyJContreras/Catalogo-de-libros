package com.example.Catalogo.service;

import com.example.Catalogo.model.Libro;
import com.example.Catalogo.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GutendexLibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> listaLibros(){
        return libroRepository.findAll();
    }

    public List<Libro> listaLibrosPorIdioma(String idioma){
        return libroRepository.findByIdioma(idioma);
    }

    public Libro crearLibro(Libro libro){
        return libroRepository.save(libro);
    }

    public Optional<Libro> libroPorId(Long id){
        return libroRepository.findById(id);
    }

    public Optional<Libro> libroPorTitulo(String titulo){
        return libroRepository.findByTituloIgnoreCase(titulo);
    }

    public Libro actualizarLibro(Long id, Libro libroDetalles ){
        Libro libro = libroRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Libro no encontrado :( "));

        libro.setTitulo(libroDetalles.getTitulo());
        libro.setIdioma(libroDetalles.getIdioma());
        libro.setNumDescargas(libroDetalles.getNumDescargas());
        libro.setAutor(libroDetalles.getAutor());
        return libroRepository.save(libro);

    }

    public void eliminarLibro(long id){
        libroRepository.deleteById(id);
    }
}



