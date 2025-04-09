[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/GmM1_iQn)
# Algoritmos 1
## Licenciatura en Ciencia De Datos - UNSAM
## Examen Parcial
- **Formato de Entrega:** Archivos de código fuente (*.java) y entrega del proyecto Java a través del assigment de GitHub.
- **Criterios mínimos de aprobación:**
    + No deben existir errores de compilación.
    + Implementar la estructura básica de la solución contemplando el POO.
    + Completar correctamente la funcionalidad requerida según el escenario propuesto.
- **Criterios de evaluación:**
    + Dominio en el diseño de soluciones utilizando conceptos del paradigma orientado a objetos.
    + Análisis y comprensión de problemas y su resolución mediante el uso de estructuras de datos adecuadas.
    + Conocimiento y aplicación de buenas prácticas de desarrollo vistas en la materia.
    + Capacidad para construir diseños de software extensible, mantenible y reutilizable.
---

En una biblioteca se está desarrollando un sistema para gestionar la carga de libros y el control de préstamos. El sistema debe permitir registrar usuarios y libros, así como administrar los préstamos de manera eficiente. Los usuarios pueden ser estudiantes o docentes, y tienen reglas diferentes respecto a la cantidad de libros que pueden tomar en préstamo.

De cada usuario se tiene un DNI y un nombre, y en el caso de los docentes además se registran sus años de antigüedad. Los estudiantes pueden tener hasta 2 libros prestados al mismo tiempo. Y los docentes pueden tener 1 libro por cada año de antigüedad. Por ejemplo, un docente con 5 años de antigüedad puede tener un máximo de 5 libros en simultáneo.
A la hora de registrar un usuario es importante verificar que este no esté registrado en el sistema (considerando el DNI).

Para los libros es necesario registrar el título, el autor, si es único en el sistema y su estado (si está prestado o disponible). Cuando a la biblioteca le donan un libro es importante registrar si este es único o no  (es decir si es el único libro con ese título y autor).

Los préstamos se componen por un identificador único en todo el sistema, una fecha de solicitud, una fecha de devolución (inicialmente *null*) y un estado que indica si el libro ha sido devuelto o no. Además se registra qué usuario realizó el préstamo y sobre qué libro. A la hora de realizar un préstamo es importante que se valide si el usuario puede pedir otro préstamo según sus restricciones y si el libro está disponible. Si el préstamo es exitoso se debe notificar al usuario, y estas notificaciones serán una impresión en consola.

Implementar las siguientes funcionalidades:
1. Implementar todas las clases necesarias que se describen en el enunciado, incluyendo los métodos necesarios para resolver las funcionalidades solicitadas.
2. Implementar las siguientes operaciones (ver anexo 1):
   + Crear una nueva biblioteca llamada Biblioteca Central.
   + Registrar 2 docentes.
   + Registrar 2 estudiantes.
   + Donar 4 libros a la biblioteca.
   + Registrar 4 préstamos utilizando los docentes y estudiantes de los puntos previos.
   + Devolver los primeros dos préstamos del punto previo.
   + Mostrar todos los préstamos del sistema.
   + Mostrar sólo los préstamos activos (no devueltos).
   + Mostrar los usuarios con al menos 2 préstamos realizados.

# Anexo 1: Ejemplo de Main
Se pude utilizar el siguiente método main para probar el ejercicio, donde ya hay un escenario armado para verificar la funcionalidad.
```
Biblioteca biblioteca = new Biblioteca("Biblioteca Central");

// Docentes
Docente ana = biblioteca.registrarDocente("Ana López",35234111, LocalDate.of(2010, 1, 1));
Docente carlos = biblioteca.registrarDocente("Carlos Pérez", 40234111, LocalDate.of(2015, 1, 1));

// Estudiantes
Estudiante laura = biblioteca.registrarEstudiante("Laura Gómez", 45234111);
Estudiante juan = biblioteca.registrarEstudiante("Juan Rodríguez", 50234111);

// Libros 
Libro cien_anios = biblioteca.donarLibro("Cien años de soledad", "Gabriel García Márquez");
Libro sapiens = biblioteca.donarLibro("Sapiens: De animales a dioses", "Yuval Noah Harari");
Libro nombre_de_la_rosa = biblioteca.donarLibro("El nombre de la rosa", "Umberto Eco");
Libro breves_respuestas = biblioteca.donarLibro("Breves respuestas a las grandes preguntas", "Stephen Hawking");

// Préstamos utilizando usuarios y libros registrados
Prestamo prestamo1 = biblioteca.registrarPrestamo(ana, cien_anios);
Prestamo prestamo2 = biblioteca.registrarPrestamo(carlos, sapiens);
Prestamo prestamo3 = biblioteca.registrarPrestamo(laura, nombre_de_la_rosa);
Prestamo prestamo4 = biblioteca.registrarPrestamo(ana, breves_respuestas);

// Devolver préstamos registrados
biblioteca.devolverPrestamo(prestamo1);  // Ana devuelve el libro "Cien años de soledad"
biblioteca.devolverPrestamo(prestamo2);  // Carlos devuelve "Sapiens: De animales a dioses"

// Mostrar todos los préstamos registrados
System.out.println("Préstamos registrados de la Biblioteca Central:");
biblioteca.mostrarPrestamos();

// Mostrar solo los préstamos activos 
System.out.println("\nPréstamos activos (no devueltos):");
biblioteca.mostrarPrestamosActivos();

// Mostrar los usuarios que han realizado al menos 2 préstamos
System.out.println("\nUsuarios con al menos 2 préstamos:");
biblioteca.mostrarUsuariosConPrestamos(2);
```
# Anexo 2: Ejemplo de salida de consola
Dado el ejemplo del main previo, se podría obtener una salida similar a la siguiente. No es necesario que se cumpla con el formato propuesto, simplemente se adjunta para verificar los datos del ejemplo.
## Salida de registrar préstamos
```
Notificando al usuario Ana López (35234111) sobre el préstamo del libro Cien años de soledad - Gabriel García Márquez
Notificando al usuario Carlos Pérez (40234111) sobre el préstamo del libro Sapiens: De animales a dioses - Yuval Noah Harari
Notificando al usuario Laura Gómez (45234111) sobre el préstamo del libro El nombre de la rosa - Umberto Eco
Notificando al usuario Ana López (35234111) sobre el préstamo del libro Breves respuestas a las grandes preguntas - Stephen Hawking
```
## Salida de los préstamos del sistema
```
Préstamos registrados de la Biblioteca Central:
Préstamo 0
 - Usuario: Ana López (35234111)
 - Libro: Cien años de soledad - Gabriel García Márquez
 - Estado: DEVUELTO
 - Fecha de solicitud: 2024-10-23
 - Fecha de devolución: 2024-10-23
Préstamo 1
 - Usuario: Carlos Pérez (40234111)
 - Libro: Sapiens: De animales a dioses - Yuval Noah Harari
 - Estado: DEVUELTO
 - Fecha de solicitud: 2024-10-23
 - Fecha de devolución: 2024-10-23
Préstamo 2
 - Usuario: Laura Gómez (45234111)
 - Libro: El nombre de la rosa - Umberto Eco
 - Estado: PENDIENTE
 - Fecha de solicitud: 2024-10-23
 - Fecha de devolución: null
Préstamo 3
 - Usuario: Ana López (35234111)
 - Libro: Breves respuestas a las grandes preguntas - Stephen Hawking
 - Estado: PENDIENTE
 - Fecha de solicitud: 2024-10-23
 - Fecha de devolución: null
```
## Salida de los préstamos activos del sistema
```
Préstamos activos (no devueltos):
Préstamo 2
 - Usuario: Laura Gómez (45234111)
 - Libro: El nombre de la rosa - Umberto Eco
 - Estado: PENDIENTE
 - Fecha de solicitud: 2024-10-23
 - Fecha de devolución: null
Préstamo 3
 - Usuario: Ana López (35234111)
 - Libro: Breves respuestas a las grandes preguntas - Stephen Hawking
 - Estado: PENDIENTE
 - Fecha de solicitud: 2024-10-23
 - Fecha de devolución: null
```

## Salida de usuarios con al menos dos préstamos registrados
```
Usuarios con al menos 2 préstamos:
Ana López (35234111)
```
