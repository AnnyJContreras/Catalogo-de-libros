package com.example.Catalogo.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class convertirDatos implements convertDatos {

    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public <T> T obtenerDatos(String json, Class<T> clase){
        try{
            return objectMapper.readValue(json,clase);
        } catch (JsonProcessingException e){
            throw new RuntimeException("Error al normalizar Json");
        }
    }

}
