package com.example.Catalogo.service;

import com.example.Catalogo.model.Autor;
import com.example.Catalogo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GutendexAutorService {
    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> listaAutores(){
        return autorRepository.findAllLibros();

    }

    public List<Autor> listaAutoresVivos(int ano){
        return autorRepository.findAutoresVivosConLibro(ano);

    }

    public Autor crearAutor(Autor autor){
        return autorRepository.save(autor);
    }

    public Optional<Autor> buscarAutorPorId(Long id){
        return autorRepository.findById(id);
    }

    public Optional<Autor> buscarAutorPorNombre(String nombre){
        return autorRepository.findByNombreIgnoreCase(nombre);
    }

    public Autor actualizarAutor(Long id,Autor autorDetalles){
        Autor autor = autorRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Autor no encontrado"));
        autor.setNombre(autorDetalles.getNombre());
        autor.setAnoNacimiento(autorDetalles.getAnoNacimiento());
        autor.setAnoFallecimiento(autorDetalles.getAnoFallecimiento());
        return autorRepository.save(autor);
    }

    public void eliminarAutor(Long id){
        autorRepository.deleteById(id);
    }
}
