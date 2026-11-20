import java.util.Scanner;

public class PersistenciaMultiplicativaDeLosNumeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();

        while (casos-- > 0) {
            long numero = sc.nextLong();
            int pasos = 0;

            while (numero >= 10) {
                long producto = 1;
                long x = numero;
                while (x > 0) {
                    producto *= x % 10;
                    x /= 10;
                }
                numero = producto;
                pasos++;
            }
            System.out.println(pasos);
        }
    }
}
