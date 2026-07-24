import java.util.Locale;
import java.util.Scanner;

/*
 * Problema 105 - Ventas
 *
 * Javier apunta las ventas de su bar de martes a domingo
 * (los lunes cierra). Para cada semana hay que decir:
 *   - Que dia se vendio mas (o EMPATE si hay empate)
 *   - Que dia se vendio menos (o EMPATE si hay empATE)
 *   - Si las ventas del domingo superan la media semanal
 *
 * La entrada termina cuando el primer valor de la semana es -1.
 */
public class Ventas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        String[] dias = {"MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO", "DOMINGO"};

        while (sc.hasNextDouble()) {
            double primera = sc.nextDouble();
            if (primera == -1) break;

            double[] ventas = new double[6];
            ventas[0] = primera;
            for (int i = 1; i < 6; i++) {
                ventas[i] = sc.nextDouble();
            }

            // Buscar maximo y minimo
            double max = ventas[0];
            double min = ventas[0];
            for (int i = 1; i < 6; i++) {
                if (ventas[i] > max) max = ventas[i];
                if (ventas[i] < min) min = ventas[i];
            }

            // Contar cuantos dias tienen el maximo y el minimo
            int countMax = 0;
            int countMin = 0;
            for (int i = 0; i < 6; i++) {
                if (ventas[i] == max) countMax++;
                if (ventas[i] == min) countMin++;
            }

            // Determinar dia de maximo y minimo
            String diaMax = "EMPATE";
            String diaMin = "EMPATE";
            if (countMax == 1) {
                for (int i = 0; i < 6; i++) {
                    if (ventas[i] == max) { diaMax = dias[i]; break; }
                }
            }
            if (countMin == 1) {
                for (int i = 0; i < 6; i++) {
                    if (ventas[i] == min) { diaMin = dias[i]; break; }
                }
            }

            // Calcular media semanal
            double suma = 0;
            for (double v : ventas) suma += v;
            double media = suma / 6;

            // Comprobar si domingo supera la media
            String domingoSupera = (ventas[5] > media) ? "SI" : "NO";

            System.out.println(diaMax + " " + diaMin + " " + domingoSupera);
        }
        sc.close();
    }
}
