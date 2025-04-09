
public class Libro {
    public String titulo;
    public String autor;
    public boolean prestado = false;
    public boolean unico = true;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void devolver() {
        prestado = false;
    }

    public void prestar() {
        prestado = true;
    }
    
    public boolean isPrestado() {
        return prestado;
    }

}
