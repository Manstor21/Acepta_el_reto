import java.util.Scanner;

public class TriangulosConPiedras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLong()) {
            long piedras = sc.nextLong();

            if (piedras == 0) {
                break;
            }

            long lado = (long) ((Math.sqrt(1 + 8.0 * piedras) - 1) / 2);

            while ((lado + 1) * (lado + 2) / 2 <= piedras) {
                lado++;
            }
            while (lado * (lado + 1) / 2 > piedras) {
                lado--;
            }

            long usadas = lado * (lado + 1) / 2;
            System.out.println(lado + " " + (piedras - usadas));
        }
    }
}
