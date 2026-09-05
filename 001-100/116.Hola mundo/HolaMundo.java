import java.util.Scanner;

/*
 * Problema 116 - !Hola mundo!
 *
 * La entrada es una unica linea con un numero n (0 <= n <= 5).
 * Hay que escribir la frase "Hola mundo." en n lineas.
 */
public class HolaMundo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Hola mundo.");
        }

        sc.close();
    }
}
