import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Tortitas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            List<Integer> pila = new ArrayList<>();
            while (true) {
                int v = sc.nextInt();
                if (v == -1) {
                    break;
                }
                pila.add(v);
            }
            if (pila.isEmpty()) {
                break;
            }

            int volteos = sc.nextInt();
            for (int i = 0; i < volteos; i++) {
                int n = sc.nextInt();
                if (n == 0) {
                    continue;
                }
                // Invertir las n tortitas de mas arriba (ultimos n elementos)
                int desde = pila.size() - n;
                Collections.reverse(pila.subList(desde, pila.size()));
            }
            System.out.println(pila.get(pila.size() - 1));
        }
        sc.close();
    }
}