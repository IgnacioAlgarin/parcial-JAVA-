import java.time.LocalDate;

public class Docente extends Usuario {
    public int antiguedad;
    public Docente(String nombre, int dni, LocalDate fechaIngreso) {
        super(nombre, dni);
        this.antiguedad = LocalDate.now().getYear() - fechaIngreso.getYear();
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    @Override  
    public int getLimitePrestamos(){
        return antiguedad;
    }

}
