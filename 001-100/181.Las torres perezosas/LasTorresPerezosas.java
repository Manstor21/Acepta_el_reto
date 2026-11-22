import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Se rellena desde la esquina inferior izquierda hacia la superior derecha:
 * cada casilla suma los caminos de abajo y de la izquierda.
 * Una X corta el paso y deja esa casilla a 0.
 */
public class LasTorresPerezosas {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder salida = new StringBuilder();

        String linea;
        while ((linea = br.readLine()) != null) {
            if (linea.trim().isEmpty()) {
                continue;
            }
            int n = Integer.parseInt(linea.trim());
            if (n == 0) {
                break;
            }

            String[] tablero = new String[n];
            for (int i = 0; i < n; i++) {
                tablero[i] = br.readLine();
            }

            long[][] formas = new long[n][n];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (tablero[i].charAt(j) == 'X') {
                        formas[i][j] = 0;
                    // La casilla de salida cuenta como un camino de longitud cero
                    } else if (i == n - 1 && j == 0) {
                        formas[i][j] = 1;
                    } else {
                        long v = 0;
                        if (i + 1 < n) {
                            v += formas[i + 1][j];
                        }
                        if (j > 0) {
                            v += formas[i][j - 1];
                        }
                        formas[i][j] = v;
                    }
                }
            }
            salida.append(formas[0][n - 1]).append('\n');
        }
        System.out.print(salida);
    }
}
