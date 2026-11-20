import java.util.Scanner;

/*
 * Problema 158 - Los saltos de Mario
 *
 * Mario salta de cada muro al siguiente. Basta con comparar la altura
 * del muro actual con la del siguiente: si el siguiente es mas alto,
 * el salto es hacia arriba; si es mas bajo, hacia abajo; si coincide,
 * no cuenta como ninguna de las dos cosas.
 */
public class LosSaltosDeMario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();

        while (casos-- > 0) {
            int muros = sc.nextInt();
            long anterior = sc.nextLong();
            long arriba = 0;
            long abajo = 0;

            for (int i = 1; i < muros; i++) {
                long altura = sc.nextLong();
                if (altura > anterior) {
                    arriba++;
                } else if (altura < anterior) {
                    abajo++;
                }
                anterior = altura;
            }

            System.out.println(arriba + " " + abajo);
        }
        sc.close();
    }
}
