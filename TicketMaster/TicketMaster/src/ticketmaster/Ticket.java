package ticketmaster;

public class Ticket {
    private int numero; 
    private int precio;
    private int cantidad; 
    private char[] nombre;
    private char[] concierto; 
    private Ticket ticket; 
    public Ticket() {
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public char[] getNombre() {
        return nombre;
    }
    public void setNombre(char[] nombre) {
        this.nombre = nombre;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public Ticket getTicket() {
        return ticket;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    public char[] getConcierto() {
        return concierto;
    }
    public void setConcierto(char[] concierto) {
        this.concierto = concierto;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }  
    
}
