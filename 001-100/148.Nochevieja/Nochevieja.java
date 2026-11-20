import java.util.Scanner;

public class Nochevieja {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String hora = sc.nextLine().trim();
            if (hora.isEmpty()) {
                continue;
            }
            int horas = Integer.parseInt(hora.substring(0, 2));
            int minutos = Integer.parseInt(hora.substring(3, 5));
            if (horas == 0 && minutos == 0) {
                break;
            }
            System.out.println(24 * 60 - (horas * 60 + minutos));
        }
        sc.close();
    }
}
