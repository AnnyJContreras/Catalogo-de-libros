# Catálogo de Libros - Proyecto Java Spring Boot

Este proyecto permite buscar, listar y registrar libros utilizando la API de [Gutendex](https://gutendex.com/), así como almacenar información de libros y autores en una base de datos local. Está desarrollado en **Java** con **Spring Boot** y sigue un enfoque MVC con servicios separados para libros, autores y conexión a la API.

---

## 📦 Características

- Buscar libros por **título** o **autor**.
- Listar todos los libros registrados en la base de datos.
- Guardar libros desde la API de Gutendex asegurando que no se repitan.
- Asociar libros a autores existentes o crear nuevos autores si no existen.
- Mostrar detalles completos de los libros: título, idioma, descargas y autor.

---

## 🛠 Tecnologías utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA** para interacción con base de datos
- **PostgreSQL** como sistema gestor de base de datos
- **Maven** como herramienta de construcción
- **Gutendex API** para obtener datos de libros y autores

---

## 🔧 Instalación

1. Clonar el repositorio:

```bash
git clone https://github.com/tuusuario/catalogo-libros.git
cd catalogo-libros
