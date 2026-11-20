import java.util.Scanner;

public class SanFermines {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String linea = sc.nextLine().trim();
            if (linea.isEmpty()) {
                continue;
            }
            String[] partes = linea.split("\\s+");
            int n = Integer.parseInt(partes[0]);
            long velMaxima = 0;
            for (int i = 1; i <= n; i++) {
                long velocidad = Long.parseLong(partes[i]);
                if (velocidad > velMaxima) {
                    velMaxima = velocidad;
                }
            }
            System.out.println(velMaxima);
        }
        sc.close();
    }
}
