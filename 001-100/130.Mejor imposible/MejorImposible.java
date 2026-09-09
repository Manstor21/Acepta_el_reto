import java.util.Scanner;

/*
 * Problema 130 - Mejor... imposible
 *
 * Un personaje camina siempre en diagonal sobre una acera cuadrada
 * de NxN baldosas. Se pide el numero minimo de movimientos en
 * diagonal para ir de (x1,y1) a (x2,y2), o IMPOSIBLE si no se
 * puede alcanzar.
 *
 * Como un alfil en ajedrez: 0 si misma posicion, 1 si estan en la
 * misma diagonal, IMPOSIBLE si tienen distinta paridad, y 2 en
 * cualquier otro caso del mismo color.
 */
public class MejorImposible {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLong()) {
            long n = sc.nextLong();
            if (n == 0) break;

            long x1 = sc.nextLong();
            long y1 = sc.nextLong();
            long x2 = sc.nextLong();
            long y2 = sc.nextLong();

            if (x1 == x2 && y1 == y2) {
                System.out.println(0);
            } else if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
                System.out.println(1);
            } else if ((x1 + y1) % 2 != (x2 + y2) % 2) {
                System.out.println("IMPOSIBLE");
            } else {
                System.out.println(2);
            }
        }

        sc.close();
    }
}
