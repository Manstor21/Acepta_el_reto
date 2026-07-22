import java.util.Scanner;

/*
 * Problema 101 - Cuadrados diabolicos y esotericos
 *
 * Un cuadrado magico es DIABOLICO si todas sus filas, columnas
 * y las dos diagonales principales suman lo mismo (constante magica CM).
 *
 * Para que sea ESOTERICO ademas tiene que:
 *   - Contener los numeros de 1 a n^2
 *   - La suma de las esquinas valer CM2 = 4*CM/n
 *   - Si n es impar: el centro * 4 = CM2 y la suma de los 4 centros
 *     de los laterales tambien = CM2
 *   - Si n es par: la suma de los 4 centros = CM2 y los centros
 *     de cada lado suman 2*CM2
 *
 * Si no es ni diabolico ni esoterico, escribimos NO.
 */
public class CuadradosMagicos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;

            int[][] tabla = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    tabla[i][j] = sc.nextInt();

            // Comprobamos si es cuadrado magico (diabolico)
            int cm = sumarFila(tabla, 0);
            if (!esDiabolico(tabla, n, cm)) {
                System.out.println("NO");
                continue;
            }

            // Si es diabolico, comprobamos si es esoterico
            if (esEsoterico(tabla, n, cm)) {
                System.out.println("ESOTERICO");
            } else {
                System.out.println("DIABOLICO");
            }
        }
        sc.close();
    }

    static int sumarFila(int[][] t, int f) {
        int s = 0;
        for (int j = 0; j < t.length; j++) s += t[f][j];
        return s;
    }

    static int sumarColumna(int[][] t, int c) {
        int s = 0;
        for (int i = 0; i < t.length; i++) s += t[i][c];
        return s;
    }

    // Comprueba que filas, columnas y diagonales sumen lo mismo
    static boolean esDiabolico(int[][] t, int n, int cm) {
        // Filas
        for (int i = 0; i < n; i++)
            if (sumarFila(t, i) != cm) return false;

        // Columnas
        for (int j = 0; j < n; j++)
            if (sumarColumna(t, j) != cm) return false;

        // Diagonal principal
        int d1 = 0;
        for (int i = 0; i < n; i++) d1 += t[i][i];
        if (d1 != cm) return false;

        // Diagonal secundaria
        int d2 = 0;
        for (int i = 0; i < n; i++) d2 += t[i][n - 1 - i];
        if (d2 != cm) return false;

        return true;
    }

    static boolean esEsoterico(int[][] t, int n, int cm) {
        // Primero comprobamos que contenga los numeros de 1 a n^2
        boolean[] visto = new boolean[n * n + 1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                int v = t[i][j];
                if (v < 1 || v > n * n || visto[v]) return false;
                visto[v] = true;
            }

        // CM2 = 4 * CM / n
        int cm2 = 4 * cm / n;
        if (4 * cm % n != 0) return false;

        // Suma de las esquinas
        int esquinas = t[0][0] + t[0][n - 1] + t[n - 1][0] + t[n - 1][n - 1];
        if (esquinas != cm2) return false;

        if (n % 2 == 1) {
            // n impar: centro * 4 = CM2
            int centro = t[n / 2][n / 2];
            if (centro * 4 != cm2) return false;

            // Suma de los 4 centros de los laterales
            int mid = n / 2;
            int laterales = t[0][mid] + t[n - 1][mid] + t[mid][0] + t[mid][n - 1];
            if (laterales != cm2) return false;
        } else {
            // n par: suma de los 4 centros = CM2
            int mid1 = n / 2 - 1;
            int mid2 = n / 2;
            int centros = t[mid1][mid1] + t[mid1][mid2] + t[mid2][mid1] + t[mid2][mid2];
            if (centros != cm2) return false;

            // Suma de los centros de los 4 laterales = 2*CM2
            int laterales = t[0][mid1] + t[0][mid2]
                          + t[n - 1][mid1] + t[n - 1][mid2]
                          + t[mid1][0] + t[mid2][0]
                          + t[mid1][n - 1] + t[mid2][n - 1];
            if (laterales != 2 * cm2) return false;
        }

        return true;
    }
}
