import java.util.Scanner;

/*
 * Problema 115 - Numero de Kaprekar
 *
 * Un numero de Kaprekar es aquel que, al elevarse al cuadrado, puede
 * descomponerse en dos partes enteras (en base 10) cuya suma es igual
 * al numero original. La primera parte puede ser 0, pero la segunda
 * NO puede ser 0 (por eso el 100 no es Kaprekar: 100^2 = 10000, y
 * 100 + 00 no vale).
 *
 * Por ejemplo, 99^2 = 9801 y 98 + 01 = 99, asi que 99 es Kaprekar.
 *
 * Como los numeros llegan hasta 65535, su cuadrado puede superar los
 * 4.3 miles de millones y no cabe en un int; por eso usamos long.
 */
public class NumeroKaprekar {
    private static boolean esKaprekar(long n) {
        long cuadrado = n * n;

        // Probamos todos los puntos posibles de corte del cuadrado.
        long potencia = 10;
        while (potencia <= cuadrado) {
            long parteAlta = cuadrado / potencia;
            long parteBaja = cuadrado % potencia;

            // La parte baja no puede ser 0 y ambas suman el original.
            if (parteBaja != 0 && parteAlta + parteBaja == n) {
                return true;
            }
            potencia *= 10;
        }

        // El caso especial: n^2 = n, con parte alta 0 y parte baja n.
        return n == cuadrado;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        while (n != 0) {
            if (esKaprekar(n)) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
            n = sc.nextLong();
        }

        sc.close();
    }
}
