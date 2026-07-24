import java.util.Scanner;

/*
 * Problema 103 - Problemas de herencia
 *
 * Cain y Abel heredan un terreno cuadrado de 1x1 hm (1 hectarea).
 * Se divide por una funcion polinomica f(x) evaluada entre 0 y 1.
 * Cain se queda con el area debajo de la funcion (lo que sobra es de Abel).
 *
 * Usamos sumas de Riemann para aproximar el area:
 *   A = sumatoria de (1/n) * f(i/n) para i de 0 a n-1
 *
 * Si f(x) < 0, no contamos nada (el terreno no baja de 0).
 * Si f(x) > 1, solo contamos 1 (no se puede tener mas del terreno).
 *
 * Si el area de Cain esta a menos de 0.001 de 0.5, es JUSTO.
 * Si tiene mas, gana CAIN. Si tiene menos, gana ABEL.
 */
public class Herencia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int grado = sc.nextInt();
            if (grado == 20) break;

            // Leer coeficientes en orden decreciente: a_n, a_{n-1}, ..., a_0
            int[] coef = new int[grado + 1];
            for (int i = 0; i <= grado; i++) {
                coef[i] = sc.nextInt();
            }

            int n = sc.nextInt();
            double base = 1.0 / n;
            double area = 0.0;

            // Suma de Riemann con el vertice superior izquierdo
            for (int i = 0; i < n; i++) {
                double x = i * base;
                double fx = evaluarPolinomio(coef, grado, x);

                // Recortar al rango [0, 1]
                if (fx < 0) fx = 0;
                if (fx > 1) fx = 1;

                area += base * fx;
            }

            // Comparar con 0.5 (mitad de la hectarea)
            if (Math.abs(area - 0.5) <= 0.001) {
                System.out.println("JUSTO");
            } else if (area > 0.5) {
                System.out.println("CAIN");
            } else {
                System.out.println("ABEL");
            }
        }
        sc.close();
    }

    // Evalua un polinomio dado por sus coeficientes en orden decreciente
    // Ejemplo: [1, 2, -1, 1] para grado 3 -> x^3 + 2x^2 - x + 1
    static double evaluarPolinomio(int[] coef, int grado, double x) {
        double resultado = 0;
        for (int i = 0; i <= grado; i++) {
            resultado += coef[i] * Math.pow(x, grado - i);
        }
        return resultado;
    }
}
