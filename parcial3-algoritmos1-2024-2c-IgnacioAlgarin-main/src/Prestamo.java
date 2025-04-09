import java.time.LocalDate;

public class Prestamo {
    public Usuario usuario;
    public Libro libro;
    public LocalDate fechaInicio;
    public LocalDate fechaFin;
    public estadoPrestamo estado;
    public static int contador = 0;
    public int id;

    public Prestamo(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaInicio = LocalDate.now();
        this.fechaFin = null;
        this.estado = estadoPrestamo.PENDIENTE;
        this.id = contador++;
    }   

    public Usuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }   

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        if(estado == estadoPrestamo.DEVUELTO){
            return LocalDate.now();
        }
        else
            return null;
    }

    public estadoPrestamo getEstado() {
        return estado;
    }

    public int getId() {
        return id;
    }   

}
