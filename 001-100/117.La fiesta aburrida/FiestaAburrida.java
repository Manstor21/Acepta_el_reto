import java.util.Scanner;

/*
 * Problema 117 - La fiesta aburrida
 *
 * La entrada comienza con un numero N (cantidad de gente). Despues
 * vienen N lineas con el formato "Soy <nombre>". Para cada persona
 * hay que escribir "Hola, <nombre>." (con punto final).
 */
public class FiestaAburrida {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String linea = sc.nextLine();
            // La linea es "Soy nombre"; tomamos todo lo que sigue a "Soy".
            String nombre = linea.substring(4).trim();
            System.out.println("Hola, " + nombre + ".");
        }

        sc.close();
    }
}
