import java.util.Scanner;

/*
 * Problema 162 - Tableros de Ajedrez
 *
 * El tablero tiene 8x8 escaques. Cada escaque ocupa "tam" caracteres:
 * los claros son espacios y los oscuros usan el caracter dado. Arriba
 * de la primera fila y debajo de la ultima se dibuja un borde con
 * 8 * tam guiones. La esquina superior izquierda es clara.
 */
public class TablerosDeAjedrez {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int tam = sc.nextInt();
            if (tam == 0) {
                break;
            }
            char negro = sc.next().charAt(0);

            StringBuilder borde = new StringBuilder("|");
            for (int i = 0; i < 8 * tam; i++) {
                borde.append('-');
            }
            borde.append('|');

            String filaClara = fila(tam, negro, true);
            String filaOscura = fila(tam, negro, false);

            System.out.println(borde);
            for (int f = 0; f < 8; f++) {
                for (int repeticion = 0; repeticion < tam; repeticion++) {
                    System.out.println(f % 2 == 0 ? filaClara : filaOscura);
                }
            }
            System.out.println(borde);
        }
        sc.close();
    }

    static String fila(int tam, char negro, boolean empiezaClara) {
        StringBuilder sb = new StringBuilder("|");
        for (int col = 0; col < 8; col++) {
            boolean clara = (col % 2 == 0) == empiezaClara;
            for (int k = 0; k < tam; k++) {
                sb.append(clara ? ' ' : negro);
            }
        }
        return sb.append('|').toString();
    }
}
