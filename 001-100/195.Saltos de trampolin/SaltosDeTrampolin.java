import java.util.Scanner;
import java.util.Arrays;

public class SaltosDeTrampolin {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String linea = sc.nextLine().trim();
            if (linea.isEmpty()) {
                continue;
            }
            String[] partes = linea.split("\\s+");
            int[] notas = new int[7];
            // Cada nota es un multiplo de 0.5; multiplicando por 2 obtenemos
            // enteros y el CD de 2.0 se cancela exactamente.
            for (int i = 0; i < 7; i++) {
                notas[i] = (int) Math.round(Double.parseDouble(partes[i]) * 2);
            }
            Arrays.sort(notas);
            int puntuacion = 0;
            for (int i = 2; i <= 4; i++) {
                puntuacion += notas[i];
            }
            System.out.println(puntuacion);
        }
        sc.close();
    }
}
