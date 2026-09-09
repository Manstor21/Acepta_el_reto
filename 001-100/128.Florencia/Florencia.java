import java.util.Scanner;

/*
 * Problema 128 - Florencia
 *
 * Un fabricante compra varillas largas de longitud L y las trocea para los
 * paraguas. Si la porcion restante es mas corta que la pieza que necesita
 * ahora, la desprecia (retal) y empieza una varilla nueva.
 *
 * Cada paraguas (nervios n, segmentos s, longitud l) necesita n*s piezas de
 * longitud l. Se simula el corte greedy por pieza.
 */
public class Florencia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            long l = sc.nextLong();
            if (l == -1) break;

            long numVarillas = 0;
            long restante = 0;
            long retal = 0;
            boolean imposible = false;

            while (true) {
                long n = sc.nextLong();
                if (n == -1) break;
                long s = sc.nextLong();
                long pieza = sc.nextLong();

                if (imposible) continue;

                if (pieza > l) {
                    imposible = true;
                    continue;
                }
                long piezas = n * s;
                while (piezas-- > 0) {
                    if (restante < pieza) {
                        retal += restante;
                        numVarillas++;
                        restante = l;
                    }
                    restante -= pieza;
                }
            }

            if (imposible) {
                System.out.println("IMPOSIBLE");
            } else {
                retal += restante;
                System.out.println(numVarillas + " " + retal);
            }
        }

        sc.close();
    }
}
