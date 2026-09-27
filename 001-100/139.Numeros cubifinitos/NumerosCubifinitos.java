import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class NumerosCubifinitos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            List<Integer> serie = new ArrayList<>();
            Set<Integer> visto = new HashSet<>();
            int actual = n;
            serie.add(actual);
            visto.add(actual);

            if (actual == 1) {
                System.out.println("1 -> cubifinito.");
                continue;
            }

            while (true) {
                int siguiente = sumaCubos(actual);
                if (siguiente == 1) {
                    // Mostrar todos los de la serie y el 1 final
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < serie.size(); i++) {
                        if (i > 0) {
                            sb.append(" - ");
                        }
                        sb.append(serie.get(i));
                    }
                    sb.append(" - 1 -> cubifinito.");
                    System.out.println(sb);
                    break;
                }
                if (visto.contains(siguiente)) {
                    // Repeticion de un numero ya visto: mostrar la serie y el repetido
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < serie.size(); i++) {
                        if (i > 0) {
                            sb.append(" - ");
                        }
                        sb.append(serie.get(i));
                    }
                    sb.append(" - ").append(siguiente).append(" -> no cubifinito.");
                    System.out.println(sb);
                    break;
                }
                serie.add(siguiente);
                visto.add(siguiente);
                actual = siguiente;
            }
        }
        sc.close();
    }

    static int sumaCubos(int n) {
        int suma = 0;
        while (n > 0) {
            int dig = n % 10;
            suma += dig * dig * dig;
            n /= 10;
        }
        return suma;
    }
}