import java.util.Scanner;

/*
 * Problema 132 - Las cartas del abuelo
 *
 * Dada una cadena y pares i,j, decidir si todos los caracteres
 * entre min(i,j) y max(i,j) (ambos inclusive) son iguales.
 *
 * Se preprocesa un array de cambios: cambio[i] = (char[i] != char[i-1])
 * y su prefijo. Un intervalo [a,b] tiene todos iguales si y solo si
 * prefijo[b] - prefijo[a] == 0. O(l + consultas).
 */
public class CartasAbuelo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String linea = sc.nextLine().trim();
            if (linea.isEmpty()) continue;

            if (!sc.hasNextLine()) break;
            String nLinea = sc.nextLine().trim();
            int n = Integer.parseInt(nLinea);
            if (n == 0) break;

            int l = linea.length();
            int[] prefijo = new int[l];
            for (int i = 1; i < l; i++) {
                prefijo[i] = prefijo[i - 1] + (linea.charAt(i) != linea.charAt(i - 1) ? 1 : 0);
            }

            for (int k = 0; k < n; k++) {
                String[] partes = sc.nextLine().trim().split("\\s+");
                int i = Integer.parseInt(partes[0]);
                int j = Integer.parseInt(partes[1]);
                int a = Math.min(i, j);
                int b = Math.max(i, j);

                if (a == b) {
                    System.out.println("SI");
                } else if (prefijo[b] - prefijo[a] == 0) {
                    System.out.println("SI");
                } else {
                    System.out.println("NO");
                }
            }

            System.out.println();
        }

        sc.close();
    }
}
