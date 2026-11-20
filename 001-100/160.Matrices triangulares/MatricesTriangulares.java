import java.util.Scanner;

/*
 * Problema 160 - Matrices triangulares
 *
 * Una matriz es triangular si todos los elementos por debajo de la
 * diagonal principal son cero (triangular superior) o si todos los
 * elementos por encima de la diagonal principal son cero (triangular
 * inferior). Puede cumplir ambas condiciones a la vez.
 */
public class MatricesTriangulares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            boolean superior = true;
            boolean inferior = true;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    long valor = sc.nextLong();
                    if (i > j && valor != 0) {
                        superior = false;
                    }
                    if (i < j && valor != 0) {
                        inferior = false;
                    }
                }
            }

            System.out.println((superior || inferior) ? "SI" : "NO");
        }
        sc.close();
    }
}
