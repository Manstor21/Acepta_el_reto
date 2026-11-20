import java.util.Scanner;

/*
 * Problema 159 - Viendo pasar el tiempo
 *
 * Se recorren todos los minutos del intervalo, ambos extremos incluidos,
 * y se comprueba si alguno de los cuatro digitos que muestra el reloj
 * (HH:MM) coincide con el digito preguntado. La lectura termina con
 * "24:00 24:00", que no se procesa.
 */
public class ViendoPasarElTiempo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String horaInicio = sc.next();
            if (!sc.hasNext()) {
                break;
            }
            String horaFin = sc.next();

            if (horaInicio.equals("24:00") && horaFin.equals("24:00")) {
                break;
            }

            int digito = sc.nextInt();
            char objetivo = (char) ('0' + digito);

            int inicio = aMinutos(horaInicio);
            int fin = aMinutos(horaFin);
            int contador = 0;

            for (int minuto = inicio; minuto <= fin; minuto++) {
                String reloj = String.format("%02d:%02d", minuto / 60, minuto % 60);
                if (reloj.charAt(0) == objetivo || reloj.charAt(1) == objetivo
                        || reloj.charAt(3) == objetivo || reloj.charAt(4) == objetivo) {
                    contador++;
                }
            }

            System.out.println(contador);
        }
        sc.close();
    }

    static int aMinutos(String hora) {
        int horas = Integer.parseInt(hora.substring(0, 2));
        int minutos = Integer.parseInt(hora.substring(3, 5));
        return horas * 60 + minutos;
    }
}
