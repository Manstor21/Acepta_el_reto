import java.util.Scanner;

/*
 * Problema 164 - Area de un rectangulo
 *
 * Se reciben las coordenadas del vertice inferior izquierdo y del
 * superior derecho. El area es (x2 - x1) * (y2 - y1). El caso que
 * termina la lectura tiene el segundo vertice debajo o a la izquierda
 * del primero.
 */
public class AreaDeUnRectangulo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            if (x2 < x1 || y2 < y1) {
                break;
            }

            System.out.println((long) (x2 - x1) * (y2 - y1));
        }
        sc.close();
    }
}
