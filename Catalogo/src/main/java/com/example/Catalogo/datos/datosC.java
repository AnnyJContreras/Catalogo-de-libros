package com.example.Catalogo.datos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class datosC {

    @JsonProperty("results")
    private List<datoLibro> libros;

    public List<datoLibro> getLibros() {
        return libros;
    }

    public void setLibros(List<datoLibro> libros) {
        this.libros = libros;
    }
}
