import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    public List<Libro> libros;
    public List<Prestamo> prestamos;
    public List<Usuario> usuarios;
    public String nombre;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.usuarios = new ArrayList<>();
        this.libros = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public Docente registrarDocente(String nombre, int dni, LocalDate ingreso) {
        for (Usuario usuario : usuarios) {
            if(usuario.getDni() == dni){
                throw new SystemException("El usuario ya existe");
            }
        }
        Docente docente = new Docente(nombre, dni, ingreso);
        usuarios.add(docente);
        return docente;
    }
    public Estudiante registrarEstudiante(String nombre, int dni) {
        for (Usuario usuario : usuarios) {
            if(usuario.getDni() == dni){
                throw new SystemException("El usuario ya existe");
            }
        }
        Estudiante estudiante = new Estudiante(nombre, dni);
        usuarios.add(estudiante);
        return estudiante;
    }

    public Libro donarLibro(String titulo, String autor) {
        Libro libro = new Libro(titulo, autor);
        libros.add(libro);
        return libro;
    }

    public Prestamo registrarPrestamo(Usuario usuario, Libro libro) {
        if (usuario.getLimitePrestamos() > contarPrestamos(usuario) && !libro.isPrestado()) {
            Prestamo prestamo = new Prestamo(usuario, libro);
            libro.prestar();
            prestamos.add(prestamo);
            System.out.println("Notificando al usuario " + usuario.getNombre() + " sobre el préstamo del libro " + libro.getTitulo());
            return prestamo;
        }
        return null;
    }

    private int contarPrestamos(Usuario usuario) {
        int contador = 0;
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getUsuario().equals(usuario)) {
                contador++;
            }
        }
        return contador;
    }


    public void devolverPrestamo(Prestamo prestamo) {
        prestamo.getLibro().devolver();
        prestamo.estado = estadoPrestamo.DEVUELTO;
    }

    public void mostrarPrestamos() {
        for (Prestamo prestamo : prestamos) {
            System.out.println("Prestamo "+ prestamo.getId());
            System.out.println("Usuario: " + prestamo.getUsuario().getNombre() + " (" + prestamo.getUsuario().getDni() + ")");
            System.out.println("Libro: " + prestamo.getLibro().getTitulo());
            System.out.println("Fecha de solicitud: " + prestamo.getFechaInicio());
            System.out.println("Fecha de devolución: " + prestamo.getFechaFin());
            System.out.println("Estado: " + prestamo.getEstado());
            System.out.println();
        }
    }

    public void mostrarUsuariosConPrestamos(int min) {
        for (Usuario usuario : usuarios) {
            if (contarPrestamos(usuario) >= min) {
                System.out.println(usuario.getNombre() + " (" + usuario.getDni() + ")");
            }
        }
    }

    public void mostrarPrestamosActivos() {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getEstado() == estadoPrestamo.PENDIENTE) {
                System.out.println("Prestamo "+ prestamo.getId());
                System.out.println("Usuario: " + prestamo.getUsuario().getNombre() + " (" + prestamo.getUsuario().getDni() + ")");
                System.out.println("Libro: " + prestamo.getLibro().getTitulo());
                System.out.println("Fecha de solicitud: " + prestamo.getFechaInicio());
                System.out.println("Fecha de devolución: " + prestamo.getFechaFin());
                System.out.println("Estado: " + prestamo.getEstado());
                System.out.println();
            }
        }
    }

}
