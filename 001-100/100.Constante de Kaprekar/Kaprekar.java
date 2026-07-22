import java.util.Scanner;

/*
 * Problema 100 - Constante de Kaprekar
 *
 * La constante de Kaprekar para numeros de 4 cifras funciona asi:
 *   1. Tomar el numero, ordenar sus digitos de mayor a menor -> numero grande
 *   2. Ordenar de menor a mayor -> numero pequenio
 *   3. Restar: grande - pequeño
 *   4. Repetir con el resultado hasta llegar a 6174
 *
 * Caso especial: si todos los digitos son iguales (como 1111), la resta da 0
 * y nunca se llega a 6174, asi que devolvemos 8 directamente.
 * Si ya nos dan 6174, el numero de pasos es 0.
 */
public class Kaprekar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();

        while (casos-- > 0) {
            int num = sc.nextInt();

            if (num == 6174) {
                System.out.println(0);
                continue;
            }

            int pasos = 0;
            int actual = num;

            // Mientras no lleguemos a la constante, seguimos restando
            while (actual != 6174) {
                int may = aNumero(ordenarDesc(actual));
                int min = aNumero(ordenarAsc(actual));
                actual = may - min;
                pasos++;

                // Si el resultado es 0, es un repdigit (todos los digitos iguales)
                // y nunca va a converger, asi que paramos y ponemos 8
                if (actual == 0) {
                    pasos = 8;
                    break;
                }
            }

            System.out.println(pasos);
        }
        sc.close();
    }

    // Separa un numero de 4 cifras en sus 4 digitos individuales
    // Ejemplo: 3524 -> [3, 5, 2, 4]
    static int[] digitos(int n) {
        int[] d = new int[4];
        d[0] = n / 1000;
        d[1] = (n / 100) % 10;
        d[2] = (n / 10) % 10;
        d[3] = n % 10;
        return d;
    }

    // Ordena los digitos de mayor a menor (bubble sort sencillo)
    // para formar el numero grande de la resta
    static int[] ordenarDesc(int n) {
        int[] d = digitos(n);
        for (int i = 0; i < 3; i++)
            for (int j = i + 1; j < 4; j++)
                if (d[i] < d[j]) {
                    int aux = d[i]; d[i] = d[j]; d[j] = aux;
                }
        return d;
    }

    // Ordena los digitos de menor a mayor para formar el numero pequeño
    static int[] ordenarAsc(int n) {
        int[] d = digitos(n);
        for (int i = 0; i < 3; i++)
            for (int j = i + 1; j < 4; j++)
                if (d[i] > d[j]) {
                    int aux = d[i]; d[i] = d[j]; d[j] = aux;
                }
        return d;
    }

    // Convierte el array de digitos de vuelta a un entero
    // [5, 4, 3, 2] -> 5432
    static int aNumero(int[] d) {
        return d[0] * 1000 + d[1] * 100 + d[2] * 10 + d[3];
    }
}
