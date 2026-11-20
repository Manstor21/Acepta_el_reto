import java.util.Scanner;

public class PintandoFractales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLong()) {
            long lado = sc.nextLong();
            long tinta = 0;
            long cuadrados = 1;

            while (lado > 0) {
                tinta += cuadrados * 4 * lado;
                cuadrados *= 4;
                lado /= 2;
            }

            System.out.println(tinta);
        }
    }
}
