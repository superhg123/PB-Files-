/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


package pilasycolas;
import java.util.Scanner;

/**
 *
 * @author Hugo Hdz Carrillo 
 */
public class PilasYColas {
   public static int leerInt(String x) {
    while(true) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println(x);
            return sc.nextInt(); 
        } catch (Exception e) {
            System.out.println("Ese valor no es entero, nuevamente...");
        }
    }
   }
   public static String leerString(String x) {
        Scanner sc = new Scanner(System.in);    
        System.out.println(x);
        return sc.nextLine(); 
   }
   public static void imprimirListaCola(Dato inicio) {
        if (inicio == null) {
            return;
        }
            System.out.println(inicio.getNombre());
            imprimirListaCola(inicio.getSiguiente());
   }
   public static void imprimirListaPila(Dato inicio) {
        if (inicio == null) {
            return; 
        }
        if (inicio.getNombre() == null) {
            return; a
        }
            imprimirListaPila(inicio.getSiguiente());
            System.out.println(inicio.getNombre());
        
   }
   public static Dato getLast(Dato inicio) 
   {
       if( inicio == null )
       {
           return null;
       }
       if( inicio.getSiguiente( ) == null )
       {
           return inicio;
       }
       return getLast(inicio.getSiguiente());
   }
   public static void main(String[] args) {
    Dato inicio = new Dato(); 
    Dato aux = null; 
    int repeticion = leerInt("Inserte la cantidad de datos a ingresar");
    for(int x = 0; x < repeticion; x++) {
        aux = getLast(inicio); 
        aux.setNombre(leerString("Inserte el nombre número " + (x+1)));
        Dato nuevo = new Dato(); 
        aux.setSiguiente(nuevo);
    }    
    System.out.println("---------- Cola -----------");
    imprimirListaCola(inicio);
    System.out.println("------------ Pila -----------");
    imprimirListaPila(inicio);
   }
}
