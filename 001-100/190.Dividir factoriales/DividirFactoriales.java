import java.util.Scanner;

/*
 * Problema 190 - Dividir factoriales
 *
 * num! / den! es el producto de den+1 a num. El resultado cabe en long.
 */
public class DividirFactoriales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLong()) {
            long num = sc.nextLong();
            long den = sc.nextLong();
            if (num < den) break;

            long resultado = 1;
            for (long i = den + 1; i <= num; i++) resultado *= i;
            System.out.println(resultado);
        }

        sc.close();
    }
}
