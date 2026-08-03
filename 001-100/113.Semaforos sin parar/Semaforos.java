import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Problema 113 - Semaforos sin parar
 *
 * Adolfo quiere cruzar la avenida a velocidad constante pasando
 * todos los semaforos en verde. Cuando empieza el recorrido todos
 * acaban de cerrarse, y el ultimo semaforo tiene que pillarlo justo
 * en el momento de abrirse o de cerrarse. La policia no multa si se
 * pasa hasta una centesima de segundo despues de que se cierre.
 *
 * Como el tiempo en el ultimo semaforo debe ser exactamente un cambio,
 * probamos los tiempos candidatos del ultimo semaforo de menor a mayor
 * (es decir, a mayor velocidad) hasta dar con uno que valga para todos.
 */
public class Semaforos {
    private static final double MARGEN = 0.01;
    private static final double V_MIN = 0.1;

    private static class Semaforo {
        int distancia;   // distancia acumulada desde el inicio de la avenida
        int cerrado;     // segundos que permanece cerrado (rojo)
        int abierto;     // segundos que permanece abierto (verde)

        Semaforo(int distancia, int cerrado, int abierto) {
            this.distancia = distancia;
            this.cerrado = cerrado;
            this.abierto = abierto;
        }
    }

    // Comprueba si pasando a una velocidad concreta se pillan
    // todos los semaforos abiertos (o recien cerrados, con el margen).
    private static boolean todosAbiertos(double velocidad, Semaforo[] semaforos) {
        for (Semaforo s : semaforos) {
            double tiempo = s.distancia / velocidad;
            double periodo = s.cerrado + s.abierto;
            double fase = tiempo % periodo;

            // El semaforo se cierra en la fase 0 y se abre en la fase 'cerrado'.
            // Solo se para si llega en mitad del rojo.
            if (fase > MARGEN && fase < s.cerrado - MARGEN) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int numSemaforos = sc.nextInt();
            int velMax = sc.nextInt();
            if (numSemaforos == 0 && velMax == 0) break;

            Semaforo[] semaforos = new Semaforo[numSemaforos];
            int distanciaTotal = 0;
            boolean siempreCerrado = false;

            for (int i = 0; i < numSemaforos; i++) {
                int tramo = sc.nextInt();
                int cerrado = sc.nextInt();
                int abierto = sc.nextInt();
                distanciaTotal += tramo;
                semaforos[i] = new Semaforo(distanciaTotal, cerrado, abierto);
                if (abierto == 0) siempreCerrado = true;
            }

            // Si algun semaforo no se abre nunca, es imposible pasarlo.
            if (siempreCerrado) {
                System.out.println("IMPOSIBLE");
                continue;
            }

            Semaforo ultimo = semaforos[numSemaforos - 1];
            int periodo = ultimo.cerrado + ultimo.abierto;

            // Tiempos en los que el ultimo semaforo cambia: se abre en
            // cerrado + m*periodo y se cierra en (m+1)*periodo. Solo valen
            // los que dan una velocidad entre la minima y la maxima.
            List<Integer> candidatos = new ArrayList<>();
            int m = 0;
            while (true) {
                int abre = ultimo.cerrado + m * periodo;
                int cierra = (m + 1) * periodo;

                double vAbre = (double) distanciaTotal / abre;
                double vCierra = (double) distanciaTotal / cierra;

                // Si ya abriendo no llega a la velocidad minima, se acabo.
                if (vAbre < V_MIN) break;
                if (vAbre <= velMax) candidatos.add(abre);

                if (vCierra < V_MIN) break;
                if (vCierra <= velMax) candidatos.add(cierra);

                m++;
            }

            boolean encontrado = false;
            for (int tiempo : candidatos) {
                double velocidad = (double) distanciaTotal / tiempo;
                if (todosAbiertos(velocidad, semaforos)) {
                    System.out.println(tiempo);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) System.out.println("IMPOSIBLE");
        }
        sc.close();
    }
}
