import java.util.Scanner;

public class SalvemosAlLinceIberico {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();
        sc.nextLine();
        for (int c = 0; c < casos; c++) {
            String carretera = "";
            while (carretera.isEmpty()) {
                carretera = sc.nextLine().trim();
            }
            System.out.println(minimosTuneles(carretera));
        }
        sc.close();
    }

    private static int minimosTuneles(String carretera) {
        int n = carretera.length();
        boolean[] cubierta = new boolean[n];
        int tuneles = 0;
        for (int i = 0; i < n; i++) {
            if (carretera.charAt(i) == '.' && !cubierta[i]) {
                tuneles++;
                // Colocamos el tunel a la derecha del primer tramo descubierto,
                // o sobre el propio tramo si estamos al final de la carretera.
                int p = (i + 1 < n) ? i + 1 : i;
                for (int k = Math.max(0, p - 1); k <= Math.min(n - 1, p + 1); k++) {
                    cubierta[k] = true;
                }
            }
        }
        return tuneles;
    }
}
