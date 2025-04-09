
public abstract class Usuario {
    public String nombre;
    public int dni;
    public Usuario(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }
    
    public abstract int getLimitePrestamos();
    
    
    
}
