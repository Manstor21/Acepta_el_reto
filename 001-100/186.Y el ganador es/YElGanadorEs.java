import java.util.Scanner;

/*
 * Problema 186 - Y el ganador es...
 *
 * Gana el equipo con más globos. Si varios empatan a lo más alto se escribe
 * EMPATE. La carpeta no lleva los puntos finales porque Windows los elimina.
 */
public class YElGanadorEs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int equipos = sc.nextInt();
            int globos = sc.nextInt();
            if (equipos == 0 && globos == 0) break;

            int[] cuentas = new int[equipos + 1];
            for (int i = 0; i < globos; i++) {
                int equipo = sc.nextInt();
                sc.next(); // color del globo
                cuentas[equipo]++;
            }

            int maximo = 0;
            for (int e = 1; e <= equipos; e++) {
                if (cuentas[e] > maximo) maximo = cuentas[e];
            }

            int ganador = -1;
            int empatados = 0;
            for (int e = 1; e <= equipos; e++) {
                if (cuentas[e] == maximo) {
                    ganador = e;
                    empatados++;
                }
            }

            if (empatados == 1) System.out.println(ganador);
            else System.out.println("EMPATE");
        }

        sc.close();
    }
}
