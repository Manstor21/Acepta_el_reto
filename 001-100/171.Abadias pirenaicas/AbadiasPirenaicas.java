import java.util.Scanner;

public class AbadiasPirenaicas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int montanas = sc.nextInt();

            if (montanas == 0) {
                break;
            }

            int[] alturas = new int[montanas];
            for (int i = 0; i < montanas; i++) {
                alturas[i] = sc.nextInt();
            }

            // De este a oeste: asi maximaAlEste ya tiene las cimas vistas
            int maximaAlEste = -1;
            int abadias = 0;

            for (int i = montanas - 1; i >= 0; i--) {
                if (alturas[i] > maximaAlEste) {
                    abadias++;
                    maximaAlEste = alturas[i];
                }
            }

            System.out.println(abadias);
        }
    }
}
