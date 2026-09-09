import java.util.Scanner;

/*
 * Problema 121 - Chicles de regalo
 *
 * Se compran unos chicles y, por cada e envoltorios, la maquina regala c
 * chicles. Cada chicle comido genera un envoltorio. Se pide el total de
 * chicles comidos y los envoltorios que sobran al final.
 *
 * Si el canje produce chicles de forma indefinida (nunca se acaba, lo que
 * ocurre cuando c >= e), se escribe "RUINA".
 *
 * Los numeros llegan hasta 10^9 y las operaciones acumuladas crecen, por
 * lo que usamos long.
 */
public class Chicles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int e = sc.nextInt();
            int c = sc.nextInt();
            long n = sc.nextLong();
            if (e == 0 && c == 0 && n == 0) break;

            // Si se regalan mas o iguales chicles que envoltorios gastados,
            // los envoltorios crecen sin fin y nunca se agota el canje.
            if (c >= e) {
                System.out.println("RUINA");
                continue;
            }

            long comidos = n;   // los comprados se comen de entrada
            long envoltorios = n; // cada chicle comido deja un envoltorio

            while (envoltorios >= e) {
                long canjes = envoltorios / e;
                envoltorios %= e;
                long regalados = canjes * c;
                comidos += regalados;
                envoltorios += regalados;
            }

            System.out.println(comidos + " " + envoltorios);
        }

        sc.close();
    }
}
