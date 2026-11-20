import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VaDeModas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            Map<Integer, Integer> frecuencias = new HashMap<>();
            int moda = 0;
            int maxFrecuencia = 0;
            for (int i = 0; i < n; i++) {
                int valor = sc.nextInt();
                int frecuencia = frecuencias.getOrDefault(valor, 0) + 1;
                frecuencias.put(valor, frecuencia);
                if (frecuencia > maxFrecuencia) {
                    maxFrecuencia = frecuencia;
                    moda = valor;
                }
            }
            System.out.println(moda);
        }
        sc.close();
    }
}
