import java.util.Scanner;

public class NumerosAfortunados {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            int[] lista = new int[n];
            for (int i = 0; i < n; i++) {
                lista[i] = i + 1;
            }
            int tam = n;

            int m = 2;
            while (m <= tam) {
                // Eliminar un numero de cada m (posiciones 1-indexed: 1, 1+m, 1+2m, ...)
                int[] nueva = new int[tam];
                int nuevos = 0;
                for (int i = 0; i < tam; i++) {
                    if (i % m != 0) { // conservar todo excepto pos 0, m, 2m, ...
                        nueva[nuevos++] = lista[i];
                    }
                }
                lista = nueva;
                tam = nuevos;
                m++;
            }

            // Imprimir en orden decreciente
            StringBuilder sb = new StringBuilder();
            sb.append(n).append(": ");
            for (int i = tam - 1; i >= 0; i--) {
                if (i < tam - 1) {
                    sb.append(' ');
                }
                sb.append(lista[i]);
            }
            System.out.println(sb);
        }
        sc.close();
    }
}