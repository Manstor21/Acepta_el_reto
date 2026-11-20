import java.util.Arrays;
import java.util.Scanner;

/*
 * Problema 161 - Calculo de la Mediana
 *
 * Se ordena la muestra. Si el numero de valores es impar, el doble de
 * la mediana es 2 veces el valor central; si es par, es la suma de los
 * dos valores centrales (que equivale al doble de su media).
 */
public class CalculoDeLaMediana {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            long[] valores = new long[n];
            for (int i = 0; i < n; i++) {
                valores[i] = sc.nextLong();
            }

            Arrays.sort(valores);

            long resultado;
            if (n % 2 == 1) {
                resultado = 2 * valores[n / 2];
            } else {
                resultado = valores[n / 2 - 1] + valores[n / 2];
            }

            System.out.println(resultado);
        }
        sc.close();
    }
}
