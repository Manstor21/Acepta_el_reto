import java.util.Scanner;

public class LaPiezaPerdida {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int piezas = sc.nextInt();

            if (piezas == 0) {
                break;
            }

            long suma = 0;
            for (int i = 0; i < piezas - 1; i++) {
                suma += sc.nextInt();
            }

            // Las piezas estan numeradas del 1 al n y solo falta una
            long esperada = (long) piezas * (piezas + 1) / 2;
            System.out.println(esperada - suma);
        }
    }
}
