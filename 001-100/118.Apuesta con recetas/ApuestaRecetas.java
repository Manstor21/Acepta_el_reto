import java.util.Scanner;

/*
 * Problema 118 - Apuesta con recetas
 *
 * Pilar, Marco y Pedro apuestan una cantidad de recetas. Debemos
 * calcular cuantas recetas deberia recibir Pedro para, sin levantar
 * sospechas, no perder nunca (independientemente de lo que reciban
 * Pilar y Marco), de forma que su apuesta se acerque lo mas posible
 * a la media de las tres cantidades que cada uno se quede.
 *
 * El limite de recetas que puede recibir cualquiera es 64 (8 amigos
 * y cada amigo reenvia a otros 8, es decir 8*8 maximas recetas en ese
 * esquema de 2 niveles).
 *
 * Casos: si el juego se considera nulo se imprime 0, si no existe
 * recetas en el rango [0, 64] que permitan no perder se imprime 'I',
 * y en otro caso el numero entero x.
 */
public class ApuestaRecetas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int apuestaPilar = sc.nextInt();
        int apuestaMarco = sc.nextInt();
        int apuestaPedro = sc.nextInt();

        while (apuestaPilar >= 0 && apuestaMarco >= 0 && apuestaPedro >= 0) {
            // Juego nulo: las tres apuestas coinciden o Pedro esta
            // entre medio de las otras dos.
            if ((apuestaPilar == apuestaMarco && apuestaPilar == apuestaPedro)
                    || (apuestaPilar < apuestaPedro && apuestaPedro < apuestaMarco)
                    || (apuestaMarco < apuestaPedro && apuestaPedro < apuestaPilar)) {
                System.out.println(0);
                apuestaPilar = sc.nextInt();
                apuestaMarco = sc.nextInt();
                apuestaPedro = sc.nextInt();
                continue;
            }

            int x;
            double media;

            // Caso de empate: alguien hizo la misma apuesta que Pedro.
            if (apuestaPilar == apuestaPedro || apuestaMarco == apuestaPedro) {
                int apuesta = (apuestaPilar != apuestaPedro) ? apuestaPilar : apuestaMarco;

                if (apuesta < apuestaPedro) {
                    x = apuesta * 3;
                    media = x / 3.0;
                    // Bajamos Pedro hasta que la distancia sea la menor posible.
                    while (Math.abs(media - apuesta) <= Math.abs(apuestaPedro - media) && x >= 0) {
                        x++;
                        media = x / 3.0;
                    }
                } else {
                    x = apuesta * 3 - 64 - 64;
                    media = (64 + 64 + x) / 3.0;
                    // Subimos Pedro hasta que la distancia sea la menor posible.
                    while (Math.abs(apuesta - media) <= Math.abs(media - apuestaPedro) && x >= 0) {
                        x--;
                        media = (64 + 64 + x) / 3.0;
                    }
                }
            } else {
                // Pedro no empata con nadie.
                if (apuestaPedro < apuestaPilar && apuestaPedro < apuestaMarco) {
                    int apuesta = Math.max(apuestaPilar, apuestaMarco);
                    x = apuesta * 3 - 64 - 64;
                    media = (64 + 64 + x) / 3.0;
                    while (Math.abs(apuesta - media) <= Math.abs(media - apuestaPedro) && x >= 0) {
                        x--;
                        media = (64 + 64 + x) / 3.0;
                    }
                } else {
                    int apuesta = Math.min(apuestaPilar, apuestaMarco);
                    x = apuesta * 3;
                    media = x / 3.0;
                    while (Math.abs(media - apuesta) <= Math.abs(apuestaPedro - media) && x >= 0) {
                        x++;
                        media = x / 3.0;
                    }
                }
            }

            if (x > 64 || x < 0) {
                System.out.println("I");
            } else {
                System.out.println((int) x);
            }

            apuestaPilar = sc.nextInt();
            apuestaMarco = sc.nextInt();
            apuestaPedro = sc.nextInt();
        }

        sc.close();
    }
}
