import java.util.Scanner;

/*
 * Problema 120 - Constante magica
 *
 * Se construye un cuadrado magico de n x n (n impar) con el metodo
 * siames, empezando por k en el centro de la fila superior y rellenando
 * con numeros consecutivos. Se pide la constante magica, es decir la
 * suma comun de filas, columnas y diagonales.
 *
 * Los numeros del cuadrado son k, k+1, ..., k+n^2-1. La suma total es
 * n^2 * (k + (k + n^2 - 1)) / 2, y la constante magica es esa suma
 * dividida entre n:
 *
 *     constante = n * (2k + n^2 - 1) / 2
 *
 * No hace falta construir la matriz; usamos la formula directa.
 */
public class ConstanteMagica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            if (n == 0 && k == 0) break;

            long constante = (long) n * (2L * k + (long) n * n - 1) / 2;
            System.out.println(constante);
        }

        sc.close();
    }
}
