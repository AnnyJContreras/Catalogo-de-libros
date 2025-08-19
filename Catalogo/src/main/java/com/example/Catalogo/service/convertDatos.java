package com.example.Catalogo.service;

public interface convertDatos {

    <T> T obtenerDatos(String Json, Class<T> clase);
}
