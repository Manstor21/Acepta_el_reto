import java.util.Scanner;

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
            if (horasReales == 0) {
                horasReales = 12;
            }
            System.out.printf("%02d:%02d%n", horasReales, minutosReales);
        }
        sc.close();
    }
}
