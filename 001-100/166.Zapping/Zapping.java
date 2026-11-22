import java.util.Scanner;

public class Zapping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int origen = sc.nextInt();
            int destino = sc.nextInt();

            if (origen == 0 && destino == 0) {
                break;
            }

            // Los 99 canales forman un circulo: mejor quedarse con la distancia corta
            int distancia = Math.abs(origen - destino);
            System.out.println(Math.min(distancia, 99 - distancia));
        }
    }
}
