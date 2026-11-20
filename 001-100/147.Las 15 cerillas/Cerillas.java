import java.util.Scanner;

public class Cerillas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int max = sc.nextInt();
            int modulo = max + 1;
            int resto = n % modulo;

            if (resto == 1) {
                // Posicion perdedora: cualquier jugada devuelve al rival a esta posicion.
                System.out.println("PIERDO");
            } else {
                // Quitar (n-1) mod (max+1) deja al rival en n' = 1 (mod max+1).
                // En posicion ganadora ese valor esta entre 1 y max.
                System.out.println((resto - 1 + modulo) % modulo);
            }
        }
    }
}
