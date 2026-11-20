import java.util.Scanner;
import java.util.ArrayDeque;

/*
 * Problema 187 - Solitario
 *
 * Se sacan las cartas del mazo de dos en dos y se apilan boca arriba.
 * Sólo se puede retirar la carta de arriba: el as inicia la pila de su palo
 * y después se colocan 2, 3, ..., 7, 10 (sota), 11 (caballo), 12 (rey).
 * Al agotar el mazo se recogen las cartas visibles y se vuelve a empezar;
 * si en una vuelta no se coloca ninguna, se pierde.
 */
public class Solitario {
    private static final String PALOS = "OCEB";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int numPalos = sc.nextInt();
            if (numPalos == 0) break;

            ArrayDeque<Integer> mazo = new ArrayDeque<>();
            for (int i = 0; i < 10 * numPalos; i++) {
                int valor = sc.nextInt();
                int palo = PALOS.indexOf(sc.next().charAt(0));
                mazo.addLast(valor * 4 + palo);
            }

            System.out.println(jugar(mazo) ? "GANA" : "PIERDE");
        }

        sc.close();
    }

    private static boolean jugar(ArrayDeque<Integer> mazo) {
        int[] siguiente = new int[13];
        siguiente[1] = 2;
        siguiente[2] = 3;
        siguiente[3] = 4;
        siguiente[4] = 5;
        siguiente[5] = 6;
        siguiente[6] = 7;
        siguiente[7] = 10;
        siguiente[10] = 11;
        siguiente[11] = 12;
        siguiente[12] = -1;

        int[] cimaPalo = new int[4]; // 0 = aún no se ha iniciado la pila
        ArrayDeque<Integer> visibles = new ArrayDeque<>();

        while (true) {
            boolean colocado = false;

            while (!mazo.isEmpty()) {
                visibles.addLast(mazo.pollFirst());
                if (!mazo.isEmpty()) visibles.addLast(mazo.pollFirst());

                while (!visibles.isEmpty()) {
                    int carta = visibles.peekLast();
                    int valor = carta / 4;
                    int palo = carta % 4;
                    boolean sePuede = cimaPalo[palo] == valor
                            || (cimaPalo[palo] == 0 && valor == 1);
                    if (!sePuede) break;

                    visibles.removeLast();
                    cimaPalo[palo] = siguiente[valor];
                    colocado = true;
                }
            }

            if (visibles.isEmpty()) return true;  // todas las cartas en su pila
            if (!colocado) return false;          // vuelta completa sin avanzar

            // Recoger sin barajar y dar la vuelta: la última carta sacada
            // (la que está arriba) pasa a ser la última del nuevo mazo.
            ArrayDeque<Integer> nuevoMazo = new ArrayDeque<>();
            for (int carta : visibles) nuevoMazo.addLast(carta);
            mazo = nuevoMazo;
            visibles.clear();
        }
    }
}
