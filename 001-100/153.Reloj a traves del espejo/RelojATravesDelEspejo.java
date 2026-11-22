import java.util.Scanner;

/*
 * En un reloj de 12 horas la hora vista y la real suman 12:00,
 * asi que basta con restar lo que marca el espejo de 12*60.
 * El modulo deja el 12:00 reflejado en si mismo.
 */
public class RelojATravesDelEspejo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();
        for (int i = 0; i < casos; i++) {
            String hora = sc.next();
            int horas = Integer.parseInt(hora.substring(0, 2));
            int minutos = Integer.parseInt(hora.substring(3, 5));
            int total = horas * 60 + minutos;
            int real = ((12 * 60 - total) % (12 * 60) + 12 * 60) % (12 * 60);
            int horasReales = real / 60;
            int minutosReales = real % 60;
            // 0 no existe en el reloj de 12 horas: es las 12
            if (horasReales == 0) {
                horasReales = 12;
            }
            System.out.printf("%02d:%02d%n", horasReales, minutosReales);
        }
        sc.close();
    }
}
