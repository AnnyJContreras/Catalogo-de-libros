package com.example.Catalogo.datos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class datoLibro {

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String titulo;

    @JsonProperty("authors")
    private List<datoAutor> autores;

    @JsonProperty("languages")
    private String idiomas;

    @JsonProperty("dowland_count")
    private String numeroDescargas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<datoAutor> getAutores() {
        return autores;
    }

    public void setAutores(List<datoAutor> autores) {
        this.autores = autores;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public String getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(String numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }
}
