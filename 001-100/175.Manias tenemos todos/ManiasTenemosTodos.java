import java.util.Scanner;

public class ManiasTenemosTodos {
    private static final char[] DIAS = {'L', 'M', 'X', 'J', 'V', 'S', 'D'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();

        while (casos-- > 0) {
            int semanas = sc.nextInt();
            int[] cuenta = new int[7];

            for (int s = 0; s < semanas; s++) {
                String fila = sc.next();
                for (int d = 0; d < 7; d++) {
                    if (fila.charAt(d) == '*') {
                        cuenta[d]++;
                    }
                }
            }

            // Cada dia se consume una pastilla por semana; se agota en la
            // semana cuenta[d] + 1. Nos quedamos con el primero cronologico.
            int mejorSemana = Integer.MAX_VALUE;
            int mejorDia = 0;
            for (int d = 0; d < 7; d++) {
                int semana = cuenta[d] + 1;
                if (semana < mejorSemana || (semana == mejorSemana && d < mejorDia)) {
                    mejorSemana = semana;
                    mejorDia = d;
                }
            }

            System.out.println(DIAS[mejorDia] + " " + mejorSemana);
        }
    }
}
