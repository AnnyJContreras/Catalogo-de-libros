package com.example.Catalogo;

import com.example.Catalogo.model.Autor;
import com.example.Catalogo.model.Libro;
import com.example.Catalogo.repository.AutorRepository;
import com.example.Catalogo.repository.LibroRepository;
import com.example.Catalogo.service.GutendexAutorService;
import com.example.Catalogo.service.GutendexLibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class LibrosApplication implements CommandLineRunner {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private GutendexLibroService libroService;

    @Autowired
    private GutendexAutorService autorService;

    private final Scanner scanner = new Scanner(System.in, "UTF-8");

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(LibrosApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE); // ⚡ solo consola, sin web
        app.run(args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Aplicación iniciada. Mostrando menú...");

        boolean running = true;
        while (running) {
            mostrarMenu();
            int opcion;
            try {
                opcion = Integer.parseInt(scanner.nextLine()); // evita problemas con nextInt()
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1 -> buscarLibroPorTitulo();
                case 2 -> listarLibrosRegistrados();
                case 3 -> listarAutoresRegistrados();
                case 4 -> buscarAutorPorNombre();
                case 5 -> {
                    System.out.println("Saliendo...");
                    running = false;
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("\n===== Catálogo de Libros =====");
        System.out.println("1. Buscar libro por título");
        System.out.println("2. Listar libros registrados");
        System.out.println("3. Listar autores registrados");
        System.out.println("4. Buscar autor por nombre");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void buscarLibroPorTitulo() {
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();

        Optional<Libro> optionalLibro = libroRepository.findByTituloIgnoreCase(titulo);

        if (optionalLibro.isPresent()) {
            System.out.println("Libro encontrado en BD: " + optionalLibro.get());
        } else {
            System.out.println("No se encontró el libro.");
        }
    }

    private void listarLibrosRegistrados() {
        List<Libro> libros = libroRepository.findAll();
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            libros.forEach(System.out::println);
        }
    }

    private void listarAutoresRegistrados() {
        List<Autor> autores = autorRepository.findAll();
        if (autores.isEmpty()) {
            System.out.println("No hay autores registrados.");
        } else {
            autores.forEach(System.out::println);
        }
    }

    private void buscarAutorPorNombre() {
        System.out.print("Ingrese el nombre del autor: ");
        String nombre = scanner.nextLine();

        Optional<Autor> autor = autorRepository.findByNombreIgnoreCase(nombre);
        if (autor.isPresent()) {
            System.out.println("Autor encontrado en BD: " + autor.get());
        } else {
            System.out.println("No se encontró el autor.");
        }
    }
}








