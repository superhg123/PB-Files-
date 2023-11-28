package pilasycolas;

public class Dato {
    private String nombre;
    private Dato siguiente; 
    private int numero;
    public Dato() {
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Dato getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(Dato siguiente) {
        this.siguiente = siguiente;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
    
}
