import java.util.Arrays;
import java.util.Scanner;

public class Triangulos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();

        while (casos-- > 0) {
            long[] lados = new long[3];
            lados[0] = sc.nextLong();
            lados[1] = sc.nextLong();
            lados[2] = sc.nextLong();
            Arrays.sort(lados);

            if (lados[0] + lados[1] <= lados[2]) {
                System.out.println("IMPOSIBLE");
            } else {
                long suma = lados[0] * lados[0] + lados[1] * lados[1];
                long mayor = lados[2] * lados[2];
                if (mayor < suma) {
                    System.out.println("ACUTANGULO");
                } else if (mayor == suma) {
                    System.out.println("RECTANGULO");
                } else {
                    System.out.println("OBTUSANGULO");
                }
            }
        }
    }
}
