import java.util.Scanner;

/*
 * Problema 188 - Encadenando palabras
 *
 * Las palabras se forman con sílabas de dos letras. Dos palabras encadenan
 * cuando la última sílaba de la primera es igual a la primera de la segunda.
 */
public class EncadenandoPalabras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String linea = sc.nextLine().trim();
            if (linea.isEmpty()) continue;

            String[] palabras = linea.split("\\s+");
            boolean bien = true;
            for (int i = 1; i < palabras.length; i++) {
                String anterior = palabras[i - 1];
                String actual = palabras[i];
                String ultima = anterior.substring(anterior.length() - 2);
                String primera = actual.substring(0, 2);
                if (!ultima.equals(primera)) {
                    bien = false;
                    break;
                }
            }
            System.out.println(bien ? "SI" : "NO");
        }

        sc.close();
    }
}
