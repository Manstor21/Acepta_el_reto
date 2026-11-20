import java.util.Scanner;

/*
 * Problema 192 - Por 3 o más 5
 *
 * Desde 1, las dos operaciones (multiplicar por 3 y sumar 5) siempre
 * aumentan el número, así que basta recorrer los valores en orden creciente.
 */
public class Por3OMas5 {
    private static final int MAX = 20000;

    public static void main(String[] args) {
        boolean[] alcanzable = new boolean[MAX + 1];
        alcanzable[1] = true;
        for (int i = 1; i <= MAX; i++) {
            if (alcanzable[i]) {
                if (i * 3 <= MAX) alcanzable[i * 3] = true;
                if (i + 5 <= MAX) alcanzable[i + 5] = true;
            }
        }

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n == 0) break;
            System.out.println(alcanzable[n] ? "SI" : "NO");
        }
        sc.close();
    }
}
