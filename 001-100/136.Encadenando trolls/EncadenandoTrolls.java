import java.util.Scanner;

public class EncadenandoTrolls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
            long fuerza = sc.nextLong();
            long tam = sc.nextLong();
            if (fuerza == 0) {
                break;
            }
            // Un enano carga el doble que un hobbit
            long capacidad = 2 * fuerza;
            System.out.println(particiones(tam, capacidad));
        }
        sc.close();
    }

    // Devuelve cuantos eslabones hay que romper para transportar la cadena.
    private static long particiones(long tam, long capacidad) {
        if (tam <= capacidad) {
            return 0;
        }
        // Partir en proporcion 2:1 (grande dos veces pequeno), el resto al grande
        long pequeno = tam / 3;
        long grande = tam - pequeno;
        return 1 + particiones(grande, capacidad) + particiones(pequeno, capacidad);
    }
}