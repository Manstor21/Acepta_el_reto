import java.util.Scanner;

/*
 * Problema 131 - Llenando piscinas
 *
 * Competicion de llenado de piscinas: cada uno tiene capacidad p,
 * barreno de b litros, y pierde 'perdida' litros por viaje. El
 * incremento neto por viaje es b - perdida. Se calcula ceil(p/neto)
 * para cada uno y se compara quién necesita menos viajes.
 *
 * Numeros hasta 10^9, se usa long. Si neto <= 0, esa piscina nunca
 * se llena (viajes infinito).
 */
public class LlenandoPiscinas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLong()) {
            long p1 = sc.nextLong();
            long b1 = sc.nextLong();
            long l1 = sc.nextLong();
            long p2 = sc.nextLong();
            long b2 = sc.nextLong();
            long l2 = sc.nextLong();

            if (p1 == 0 || p2 == 0) break;

            long neto1 = b1 - l1;
            long neto2 = b2 - l2;

            long viajes1 = (neto1 > 0) ? (p1 + neto1 - 1) / neto1 : Long.MAX_VALUE;
            long viajes2 = (neto2 > 0) ? (p2 + neto2 - 1) / neto2 : Long.MAX_VALUE;

            if (viajes1 < viajes2) {
                System.out.println("YO " + viajes1);
            } else if (viajes2 < viajes1) {
                System.out.println("VECINO " + viajes2);
            } else {
                System.out.println("EMPATE " + viajes1);
            }
        }

        sc.close();
    }
}
