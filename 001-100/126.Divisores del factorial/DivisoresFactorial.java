import java.util.Scanner;

/*
 * Problema 126 - Divisores del factorial
 *
 * Se pregunta si p divide a n! (con fact(0) = 1). p es primo, y aqui el 1
 * se considera primo. Como p es primo, p divide a n! si y solo si p <= n
 * (siempre que p >= 1, y el 1 divide a todo).
 *
 * No hace falta calcular factoriales: basta comparar p con n.
 */
public class DivisoresFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            long p = sc.nextLong();
            long n = sc.nextLong();
            if (p == -1 && n == -1) break;

            System.out.println(p <= n ? "YES" : "NO");
        }

        sc.close();
    }
}
