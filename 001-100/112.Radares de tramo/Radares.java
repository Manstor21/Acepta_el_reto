import java.util.Scanner;

/*
 * Problema 112 - Radares de tramo
 *
 * Calculamos la velocidad media de un coche en un tramo.
 * Si la velocidad supera el limite, hay MULTA.
 * Si supera el limite en un 20% o mas, PUNTOS (retirada de puntos).
 * Si algun valor es negativo, ERROR.
 */
public class Radares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int distancia = sc.nextInt();
            int velMax = sc.nextInt();
            int segundos = sc.nextInt();

            if (distancia == 0 && velMax == 0 && segundos == 0) break;

            if (distancia < 0 || velMax < 0 || segundos < 0) {
                System.out.println("ERROR");
                continue;
            }

            // Velocidad media en km/h = (distancia en km) / (tiempo en h)
            // distancia en metros / 1000 = km
            // segundos / 3600 = horas
            // velocidad = (distancia / 1000) / (segundos / 3600) = distancia * 3.6 / segundos
            double velMedia = (double) distancia * 3.6 / segundos;

            if (velMedia <= velMax) {
                System.out.println("OK");
            } else if (velMedia < velMax * 1.2) {
                System.out.println("MULTA");
            } else {
                System.out.println("PUNTOS");
            }
        }
        sc.close();
    }
}
