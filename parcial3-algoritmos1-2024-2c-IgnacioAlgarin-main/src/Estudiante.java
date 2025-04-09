
public class Estudiante extends Usuario {
    public Estudiante(String nombre, int dni) {
        super(nombre, dni);
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    @Override
    public int getLimitePrestamos(){
        return 2;
    }

}
