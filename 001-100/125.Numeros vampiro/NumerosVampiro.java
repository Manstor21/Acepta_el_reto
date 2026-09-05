import java.util.Arrays;
import java.util.Scanner;

/*
 * Problema 125 - Numeros vampiro
 *
 * Un numero vampiro verdadero (con pedigri) cumple:
 *  (a) numero PAR de digitos;
 *  (b) se obtiene multiplicando dos colmillos con la mitad de digitos;
 *  (c) los colmillos tienen los mismos digitos que el original;
 *  (d) los colmillos no acaban simultaneamente en 0.
 *
 * Para un numero de 2k digitos se recorre d desde 10^(k-1) hasta sqrt(n);
 * si n % d == 0, el otro colmillo n/d debe tener k digitos y hay que
 * comprobar digitos y la condicion de los ceros finales.
 */
public class NumerosVampiro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int casos = sc.nextInt();
        while (casos-- > 0) {
            long n = sc.nextLong();
            System.out.println(esVampiro(n) ? "SI" : "NO");
        }

        sc.close();
    }

    private static boolean esVampiro(long n) {
        String s = Long.toString(n);
        int digitos = s.length();
        if (digitos % 2 != 0) return false;

        int k = digitos / 2;
        long limite = (long) Math.pow(10, k - 1);
        long raiz = (long) Math.sqrt(n);

        char[] original = s.toCharArray();
        Arrays.sort(original);

        for (long d = limite; d <= raiz; d++) {
            if (n % d != 0) continue;
            long otro = n / d;
            if (Long.toString(otro).length() != k) continue;
            if (d % 10 == 0 && otro % 10 == 0) continue;

            char[] d1 = Long.toString(d).toCharArray();
            char[] d2 = Long.toString(otro).toCharArray();
            char[] concat = (new String(d1) + new String(d2)).toCharArray();
            Arrays.sort(concat);
            if (Arrays.equals(concat, original)) return true;
        }

        return false;
    }
}
