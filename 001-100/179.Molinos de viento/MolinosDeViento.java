import java.util.Scanner;

public class MolinosDeViento {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            long[] acumulada = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                acumulada[i] = acumulada[i - 1] + sc.nextLong();
            }

            int consultas = sc.nextInt();
            StringBuilder salida = new StringBuilder();
            while (consultas-- > 0) {
                int ini = sc.nextInt();
                int fin = sc.nextInt();
                salida.append(acumulada[fin] - acumulada[ini - 1]).append('\n');
            }
            System.out.print(salida);
        }
    }
}
