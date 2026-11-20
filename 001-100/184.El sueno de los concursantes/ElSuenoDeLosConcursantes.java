import java.util.Scanner;

/*
 * Problema 184 - El sueño de los concursantes
 *
 * Se suma lo dormido en cada noche. Una noche puede cruzar la medianoche,
 * por eso si la hora de despertar es menor que la de dormirse se suman
 * 24 horas.
 */
public class ElSuenoDeLosConcursantes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int noches = sc.nextInt();
            if (noches == 0) break;

            int total = 0;
            for (int i = 0; i < noches; i++) {
                String noche = sc.next();
                String[] horas = noche.split("-");
                int dormir = aMinutos(horas[0]);
                int despertar = aMinutos(horas[1]);
                if (despertar < dormir) despertar += 24 * 60;
                total += despertar - dormir;
            }

            System.out.println(String.format("%02d:%02d", total / 60, total % 60));
        }

        sc.close();
    }

    private static int aMinutos(String hhmm) {
        int h = Integer.parseInt(hhmm.substring(0, 2));
        int m = Integer.parseInt(hhmm.substring(3, 5));
        return h * 60 + m;
    }
}
