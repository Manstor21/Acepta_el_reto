import java.util.Scanner;

public class Anelidos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder salida = new StringBuilder();

        while (sc.hasNext()) {
            int fases = sc.nextInt();
            String configuracion = sc.next();

            int longitud = configuracion.length() - 1;
            if (longitud == 0) {
                break;
            }

            int[] anillos = new int[longitud];
            for (int i = 0; i < longitud; i++) {
                anillos[i] = configuracion.charAt(i) == 'A' ? 0 : 1;
            }

            // Cada fase aplica A -> AN y N -> NA (morfismo de Thue-Morse):
            // tras k fases cada anillo genera un bloque de 2^k caracteres en
            // el que el color se invierte segun la paridad de bitCount(i).
            int bloque = 1 << fases;
            StringBuilder linea = new StringBuilder(longitud * bloque + 1);
            for (int color : anillos) {
                for (int i = 0; i < bloque; i++) {
                    int c = color ^ (Integer.bitCount(i) & 1);
                    linea.append(c == 0 ? 'A' : 'N');
                }
            }
            linea.append('C');
            salida.append(linea).append('\n');
        }
        System.out.print(salida);
    }
}
