import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
 * Problema 185 - Potitos
 *
 * Un ingrediente no le gusta al niño si aparece en algún potito que rechazó
 * (NO:) y no aparece en ninguno que se comió (SI:).
 */
public class Potitos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            if (num == 0) break;
            sc.nextLine(); // terminar la línea del número

            Set<String> gustan = new HashSet<>();
            TreeSet<String> sospechosos = new TreeSet<>();

            for (int i = 0; i < num; i++) {
                String[] palabras = sc.nextLine().trim().split("\\s+");
                boolean si = palabras[0].equals("SI:");
                for (int j = 1; j < palabras.length && !palabras[j].equals("FIN"); j++) {
                    if (si) gustan.add(palabras[j]);
                    else sospechosos.add(palabras[j]);
                }
            }

            sospechosos.removeAll(gustan);

            StringBuilder linea = new StringBuilder();
            for (String ingrediente : sospechosos) {
                if (linea.length() > 0) linea.append(' ');
                linea.append(ingrediente);
            }
            System.out.println(linea.toString());
        }

        sc.close();
    }
}
