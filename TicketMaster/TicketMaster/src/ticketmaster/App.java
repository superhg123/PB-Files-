
package ticketmaster;
/**
 *
 * @author Hugo HDZ
 */
import java.util.Scanner;
public class App {
    //Variables estáticas

    static Ticket inicial = new Ticket();
    static char[][] conciertos = {"Concierto 1 (1)".toCharArray(), "Concierto 2 (2)".toCharArray(), "Concierto 3 (3)".toCharArray(), "Concierto 4 (4)".toCharArray(), "Concierto 5 (5)".toCharArray()}; 
    static int[] precios = {1200, 600, 1400, 300, 454}; 

    // Procesos
    public static int leerInt(String x) {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in); 
                System.out.println(x);
                return sc.nextInt();
            } catch (Exception e) {
                System.out.println("Inserte un valor válido");
            }
        }
    }
    public static char[] leerCharArray (String x) {
        Scanner sc = new Scanner(System.in); 
        System.out.println(x);
        String retorno = sc.nextLine();
        return retorno.toCharArray(); 
    }
    public static int limitarRango(int numMenor, int numMayor, String x) {
        while (true) {
            try {
                int num = leerInt(x);
                if (num < numMenor || num > numMayor) {
                    throw new Exception(); 
                } else {
                    return num; 
                }
            } catch (Exception e) {
                System.out.println("Ese número no se encuentra dentro del rango de opciones, nuevamente...");
            }
        }
    }
    public static Ticket encontrarUltimo() {
        Ticket aux = new Ticket(); 
        aux = inicial; 
        while (true) {
            if (aux.getTicket() == null) {
                return aux; 
            } else {
                aux = aux.getTicket(); 
            }
        }
    }
    public static int numDeBoleto() {
        Ticket aux = new Ticket(); 
        aux = inicial;
        int num = aux.getNumero(); 
        while (true) {
            if (aux.getTicket() == null) {
                return num; 
            } else {
                aux = aux.getTicket(); 
                num++; 
            }
        }
    }
    public static void imprimirLista() {
        Ticket aux = new Ticket(); 
        aux = inicial; 
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %n", "N. de Boleto","Nombre", "Concierto", "Precio", "Cantidad");
        while(true) {
            if (aux.getTicket() == null) {
                break;
            } else {
                System.out.printf("%-20s %-20s %-20s %-20s %-20s %n", aux.getNumero(),charAString(aux.getNombre()), charAString(aux.getConcierto()), aux.getPrecio(), aux.getCantidad());
                aux = aux.getTicket();
            }
        }
    }
    public static String charAString(char[] arreglo) {
        String regreso = "";
        for(char i: arreglo) {
            regreso += i;
        }
        return regreso; 
    }
    //Submódulos
    public static void Compra() {
            for(int y = 0; y < conciertos.length; y++) {
                System.out.println(charAString(conciertos[y]) + " precio: " + precios[y]);
            }
            System.out.println("");
        
        int numConcierto = (limitarRango(1, 5, "Inserte el número del concierto al que desea asistir ")-1);
        Ticket boleto = encontrarUltimo(); 
        boleto.setConcierto(conciertos[numConcierto]);
        boleto.setNombre(leerCharArray("Inserte su nombre"));
        boleto.setNumero(numDeBoleto());
        boleto.setPrecio(precios[numConcierto]);
        boleto.setCantidad(limitarRango(1, 100, "Inserte la cantidad de boletos a comprar (Maximo 100)")); 
        Ticket aux = new Ticket(); 
        boleto.setTicket(aux);
        }
    public static void Lista() {
        imprimirLista();
    }   
    public static void main(String[] args) {
        inicial.setNumero(1);
        boolean salir = false;
        System.out.println("Bienvenido a ticketmaster" + '\n' + "inserte alguna de las siguientes opciones");
        while(true) {
           System.out.println("1.- Comprar" + '\n' + "2.- Lista de boletos" + '\n' + "3.- Salir");
            int menu = limitarRango(1, 3, "Inserte alguno de las siguientes opciones"); 
            switch (menu) {
                case 1:
                    Compra();
                    break;
                case 2:
                    Lista();
                    break; 
                default:
                salir = true; 
                    break;
            }
            if (salir == true) {
                break; 
            }
        }
        
        System.out.println("Gracias por utilizar el software");
        System.out.println("Prueba de github");
    }
}
