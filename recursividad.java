import java.util.Scanner;

public class recursividad {
    public static int leerInt(String x) {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println(x);
                return sc.nextInt();
            } catch (ArithmeticException e) {
                System.out.println("Inserte un valor válido");
            }
        }
    }

    public static String leerString(String x) {
        System.out.println(x);
        Scanner sc = new Scanner((System.in));
        return sc.nextLine();
    }

    public static int verificarRango(int numMayor, int numMenor, String x) {
        while (true) {
            try {
                int num = leerInt(x);
                if (num < numMenor || num > numMayor) {
                    throw new Exception();
                } else {
                    return num;
                }
            } catch (Exception e) {
                System.out.println("Inserte una opción que se encuentre dentro del rango de opciones");
            }
        }
    }

    public static int[] conteo(int[] lista, int[] contador, int pos) {
        if (pos < 0) {
            return contador;
        } else {
            int num = lista[pos];
            if (num < 5) {
                contador[0]++;
            } else {
                num -= 5;
                contador[num]++;
                System.out.println(contador[num]);
            }
            return conteo(lista, contador, pos - 1);
        }
    }

    public static int[] conteoMM(int[] lista, int[] mayorYmenor, int pos) {
        if (pos < 0) {
            return mayorYmenor;
        } else {
            if (lista[pos] > mayorYmenor[0]) {
                mayorYmenor[0] = lista[pos];
            } else if (lista[pos] < mayorYmenor[1]) {
                mayorYmenor[1] = lista[pos];
            }
            return conteoMM(lista, mayorYmenor, pos - 1);
        }
    }

    public static int[] conteoCaracteres(String frase, int contador[], int posF, int posA) {
        frase = frase.toLowerCase();
        String abc = "abcdefghijklmnñopqrstuvwxyz"; // Vocales en 0, 4 , 8, 15, 21
        if (posF < 0) {
            contador[1] = frase.length() - contador[0] - (contador[2] - 1);
            return contador;
        } else {
            try {
                if (frase.charAt(posF) == abc.charAt(posA)) {
                    contador[0] += 1;
                    return conteoCaracteres(frase, contador, posF - 1, 0);
                } else if (frase.charAt(posF) == ' ') {
                    contador[2] += 1;
                    return conteoCaracteres(frase, contador, posF - 1, 0);
                } else {
                    return conteoCaracteres(frase, contador, posF, posA + 1);
                }
            } catch (Exception e) {
                return conteoCaracteres(frase, contador, posF - 1, 0);
            }

        }

    }

    static String vocales = "aeiou";

    public static int[] conteoVocales(String frase, int[] contador, int posF, int posV) {
        frase = frase.toLowerCase();
        if (posF < 0) {
            return contador;
        } else {
            try {
                if (frase.charAt(posF) == vocales.charAt(posV)) {
                    contador[posV] += 1;
                    return conteoVocales(frase, contador, posF - 1, 0);
                } else {
                    return conteoVocales(frase, contador, posF, posV + 1);
                }
            } catch (Exception e) {
                return conteoVocales(frase, contador, posF - 1, 0);
            }
        }

    }

    public static int[] conteoMayus(String frase, int[] contador, int posF, int posA) {
        String abc = "abcdefghijklmnñopqrstuvwxyz"; // Vocales en 0, 4 , 8, 15, 21
        if (posF < 0) {
            contador[1] = frase.length() - contador[0] - contador[2];
            return contador;
        } else {
            try {
                if (frase.charAt(posF) == abc.charAt(posA)) {
                    contador[0] += 1;
                    return conteoMayus(frase, contador, posF - 1, 0);
                } else if (frase.charAt(posF) == ' ') {
                    contador[2] += 1;
                    return conteoMayus(frase, contador, posF - 1, 0);
                } else {
                    return conteoMayus(frase, contador, posF, posA + 1);
                }
            } catch (Exception e) {
                return conteoMayus(frase, contador, posF - 1, 0);
            }

        }

    }

    public static void calificaciones() {
        int[] calificaciones = new int[leerInt("Inserte el total de calificaciones a ingresar")];
        for (int x = 0; x < calificaciones.length; x++) {
            calificaciones[x] = verificarRango(10, 1, "Inserte la calificación " + (x + 1));
        }
        int[] contador = { 0, 0, 0, 0, 0, 0 };
        contador = conteo(calificaciones, contador, calificaciones.length - 1);
        System.out.println("Hay un total de " + calificaciones.length + " de las cuales");
        for (int x = 0; x < contador.length; x++) {
            if (x == 0 && contador[x] > 0) {
                System.out.println(contador[x] + " son reprobatorias");
            } else {
                if (contador[x] > 0) {
                    if (contador[x] == 1) {
                        System.out.println(contador[x] + " es de " + (x + 5));
                    } else {
                        System.out.println(contador[x] + " son de " + (x + 5));
                    }

                }
            }
        }
        int[] mayoryMenor = { 0, 10 };
        mayoryMenor = conteoMM(calificaciones, mayoryMenor, calificaciones.length - 1);
        System.out.println("La calificación mayor es de " + mayoryMenor[0]);
        System.out.println("La calificación menor es de " + mayoryMenor[1]);
    }

    public static void frases() {
        String frase = leerString("Inserte su frase");
        int[] contador = { 0, 0, 1 };
        contador = conteoCaracteres(frase, contador, frase.length() - 1, 0);
        System.out.println("Su frase tiene un total de " + contador[0] + " caracteres");
        contador[2] -= (contador[0] == 0) ? 1 : 0;
        System.out.println("Su frase tiene un total de " + contador[2] + " palabras");
        System.out.println("Su frase tiene un total de " + contador[1] + " simbolos");
        int[] vocalesCuenta = { 0, 0, 0, 0, 0 };
        vocalesCuenta = conteoVocales(frase, vocalesCuenta, frase.length(), 0);
        System.out.println("Vocales: ");
        for (int x = 0; x < vocalesCuenta.length; x++) {
            System.out.printf("%-10s %-10s %n", vocales.charAt(x), vocalesCuenta[x]);
        }
        int[] Mym = { 0, 0, 0 };
        Mym = conteoMayus(frase, Mym, frase.length() - 1, 0);
        System.out.println("Mayúsculas: " + Mym[1]);
        System.out.println("Minúsuclas: " + Mym[0]);
    }

    public static void main(String args[]) {
        System.out.println("1.- Calificaciones");
        System.out.println("2.- Conteo de palabras");
        int eleccion = verificarRango(2, 1, "Inserte el programa a ejecutar");
        if (eleccion == 1) {
            calificaciones();
        } else {
            frases();
        }
    }
}