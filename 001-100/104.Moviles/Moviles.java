import java.util.Scanner;

/*
 * Problema 104 - Moviles
 *
 * Un movil es una estructura recursiva: tiene un lado izquierdo
 * y uno derecho, cada uno con un peso y una distancia al punto
 * de apoyo. Si el peso es 0, significa que hay un submovil
 * colgado en ese lado.
 *
 * Para que un movil este en equilibrio:
 *   1. pi * di = pd * dd (la suma de momentos debe ser igual)
 *   2. Todos sus submoviles deben estar tambien equilibrados
 *
 * El peso de un submovil es la suma de todos sus pesos hoja.
 *
 * Leemos la entrada de forma recursiva: cada movil se lee de
 * una linea, y si tiene submoviles, estos se leen despues.
 */
public class Moviles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int pi = sc.nextInt();
            int di = sc.nextInt();
            int pd = sc.nextInt();
            int dd = sc.nextInt();

            if (pi == 0 && di == 0 && pd == 0 && dd == 0) break;

            int[] resultado = leerMovil(pi, di, pd, dd, sc);
            // resultado[0] = peso total, resultado[1] = 1 si equilibrado, 0 si no
            System.out.println(resultado[1] == 1 ? "SI" : "NO");
        }
        sc.close();
    }

    // Lee un movil (o submovil) recursivamente
    // Devuelve [pesoTotal, equilibrado]
    static int[] leerMovil(int pi, int di, int pd, int dd, Scanner sc) {
        int pesoIzq = 0;
        int pesoDer = 0;
        boolean eqIzq = true;
        boolean eqDer = true;

        // Si pi es 0, hay un submovil a la izquierda
        if (pi == 0) {
            int subPi = sc.nextInt();
            int subDi = sc.nextInt();
            int subPd = sc.nextInt();
            int subDd = sc.nextInt();
            int[] res = leerMovil(subPi, subDi, subPd, subDd, sc);
            pesoIzq = res[0];
            eqIzq = res[1] == 1;
        } else {
            pesoIzq = pi;
        }

        // Si pd es 0, hay un submovil a la derecha
        if (pd == 0) {
            int subPi = sc.nextInt();
            int subDi = sc.nextInt();
            int subPd = sc.nextInt();
            int subDd = sc.nextInt();
            int[] res = leerMovil(subPi, subDi, subPd, subDd, sc);
            pesoDer = res[0];
            eqDer = res[1] == 1;
        } else {
            pesoDer = pd;
        }

        int pesoTotal = pesoIzq + pesoDer;
        boolean equilibrado = (pesoIzq * di == pesoDer * dd) && eqIzq && eqDer;

        return new int[]{pesoTotal, equilibrado ? 1 : 0};
    }
}
