import java.util.Scanner;

/*
 * Solo puntua quien tenia el saque; al perderlo solo cambia de manos.
 * Un set se cierra a 9 puntos con dos de ventaja y su ganador saca el siguiente.
 * La F corta el partido: lo jugado hasta ahi puede ser un marcador parcial.
 */
public class PartidoDeSquash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String linea = sc.nextLine().trim();

            if (linea.isEmpty()) {
                continue;
            }
            if (linea.equals("F")) {
                break;
            }

            StringBuilder resultado = new StringBuilder();
            int puntosA = 0;
            int puntosB = 0;
            int setsA = 0;
            int setsB = 0;
            char saque = 'A';

            for (int i = 0; i < linea.length(); i++) {
                char ganador = linea.charAt(i);

                // Al llegar a tres sets no se juega el siguiente punto
                if (ganador == 'F' || setsA == 3 || setsB == 3) {
                    break;
                }

                if (ganador == saque) {
                    if (ganador == 'A') {
                        puntosA++;
                    } else {
                        puntosB++;
                    }
                } else {
                    saque = ganador;
                }

                if (Math.max(puntosA, puntosB) >= 9 && Math.abs(puntosA - puntosB) >= 2) {
                    if (resultado.length() > 0) {
                        resultado.append(' ');
                    }
                    resultado.append(puntosA).append('-').append(puntosB);

                    if (puntosA > puntosB) {
                        setsA++;
                        saque = 'A';
                    } else {
                        setsB++;
                        saque = 'B';
                    }
                    puntosA = 0;
                    puntosB = 0;
                }
            }

            if (resultado.length() == 0 || puntosA != 0 || puntosB != 0) {
                if (resultado.length() > 0) {
                    resultado.append(' ');
                }
                resultado.append(puntosA).append('-').append(puntosB);
            }

            System.out.println(resultado);
        }
    }
}
