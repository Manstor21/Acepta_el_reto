import java.util.Locale;
import java.util.Scanner;

/*
 * Problema 107 - Aproximacion de Gauss
 *
 * Gauss descubrio que el numero de primos menores que N se
 * aproxima bastante bien con N/ln(N) (donde ln es el logaritmo
 * natural). Esto es el Teorema de los Numeros Primos.
 *
 * El error de esta aproximacion es:
 *   error = pi(N)/N - 1/ln(N)
 *
 * donde pi(N) es el numero real de primos entre 1 y N.
 *
 * Para cada caso de entrada nos dan N y un valor m que define
 * el error maximo permitido: 1/10^m. Hay que decir si el error
 * absoluto es Mayor, Igual o Menor que ese umbral.
 *
 * Usamos la Criba de Eratostenes para precalcular los primos
 * hasta 100.000.
 */
public class Gauss {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        // Criba de Eratostenes hasta 100.000
        int MAX = 100000;
        boolean[] esPrimo = new boolean[MAX + 1];
        for (int i = 2; i <= MAX; i++) esPrimo[i] = true;
        for (int i = 2; i * i <= MAX; i++) {
            if (esPrimo[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    esPrimo[j] = false;
                }
            }
        }

        // Precomputar cuantos primos hay hasta cada numero
        int[] pi = new int[MAX + 1];
        for (int i = 2; i <= MAX; i++) {
            pi[i] = pi[i - 1] + (esPrimo[i] ? 1 : 0);
        }

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0 && m == 0) break;

            // Aproximacion de Gauss: n / ln(n)
            double error = Math.abs(pi[n] / (double) n - 1.0 / Math.log(n));
            double umbral = 1.0 / Math.pow(10, m);

            if (error > umbral) {
                System.out.println("Mayor");
            } else if (error < umbral) {
                System.out.println("Menor");
            } else {
                System.out.println("Igual");
            }
        }
        sc.close();
    }
}
