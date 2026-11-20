import java.util.Scanner;
import java.util.TreeSet;

public class JuegoConNumeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long[] potencias = new long[19];
        potencias[0] = 1;
        for (int i = 1; i < potencias.length; i++) {
            potencias[i] = potencias[i - 1] * 10;
        }

        while (sc.hasNextLong()) {
            long primero = sc.nextLong();
            if (primero == 0) {
                break;
            }

            long[] numeros = new long[8];
            numeros[0] = primero;
            for (int i = 1; i < 8; i++) {
                numeros[i] = sc.nextLong();
            }

            // La longitud de la concatenacion crece exactamente cuando algun
            // numero alcanza una potencia de 10. El turno k es de Zipi si es
            // impar y de Zape si es par.
            TreeSet<Long> puntos = new TreeSet<>();
            for (long a : numeros) {
                for (int m = 1; m < potencias.length; m++) {
                    long k = potencias[m] - a;
                    if (k >= 1 && k <= 10000000L) {
                        puntos.add(k);
                    }
                }
            }

            int zipi = 0;
            int zape = 0;
            StringBuilder salida = new StringBuilder();
            for (long k : puntos) {
                if ((k & 1L) == 1L) {
                    salida.append("Zipi: ").append(k).append('\n');
                    zipi++;
                } else {
                    salida.append("Zape: ").append(k).append('\n');
                    zape++;
                }
            }
            salida.append("Resultado final: Zipi: ").append(zipi)
                  .append(" Zape: ").append(zape).append('\n');
            System.out.print(salida);
        }
    }
}
