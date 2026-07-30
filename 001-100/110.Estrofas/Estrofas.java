import java.util.Scanner;

/*
 * Problema 110 - Estrofas
 *
 * Identificamos tipos de estrofa segun el esquema de rimas:
 *   - PAREADO (2 versos): rima consonante AA
 *   - TERCETO (3 versos): rima consonante A-A (AAA no vale)
 *   - CUARTETO (4 versos): consonante ABBA
 *   - CUARTETA (4 versos): consonante ABAB
 *   - SEGUIDILLA (4 versos): asonante -a-a
 *   - CUADERNA VIA (4 versos): consonante AAAA
 *
 * Todas las palabras son llanas (acento en la penultima silaba).
 * Rima consonante: coinciden vocales y consonantes desde la
 *   ultima vocal acentuada hasta el final.
 * Rima asonante: solo coinciden las vocales.
 */
public class Estrofas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            sc.nextLine();
            if (n == 0) break;

            String[] versos = new String[n];
            for (int i = 0; i < n; i++) {
                versos[i] = sc.nextLine().trim();
            }

            // Obtener la ultima palabra de cada verso
            String[] ultimaPalabra = new String[n];
            for (int i = 0; i < n; i++) {
                String[] palabras = versos[i].split(" ");
                String ultima = palabras[palabras.length - 1];
                // Quitar signos de puntuacion
                ultimaPalabra[i] = ultima.replaceAll("[^a-zA-Z]", "");
            }

            // Calcular las rimas consonantes y asonantes
            String[] rimaCons = new String[n];
            String[] rimaAson = new String[n];
            for (int i = 0; i < n; i++) {
                String p = ultimaPalabra[i];
                // Buscar la ultima vocal que no sea la ultima letra
                String vocales = "aeiou";
                int ultimaVocal = -1;
                for (int j = 0; j < p.length() - 1; j++) {
                    char c = p.charAt(j);
                    if (vocales.indexOf(c) >= 0) {
                        ultimaVocal = j;
                    }
                }
                if (ultimaVocal >= 0) {
                    rimaCons[i] = p.substring(ultimaVocal);
                    StringBuilder sb = new StringBuilder();
                    for (int j = ultimaVocal; j < p.length(); j++) {
                        char c = p.charAt(j);
                        if (vocales.indexOf(c) >= 0) {
                            sb.append(c);
                        }
                    }
                    rimaAson[i] = sb.toString();
                } else {
                    rimaCons[i] = p;
                    rimaAson[i] = p;
                }
            }

            String resultado = "DESCONOCIDO";

            if (n == 2) {
                // PAREADO: rima consonante AA
                if (rimaCons[0].equals(rimaCons[1])) {
                    resultado = "PAREADO";
                }
            } else if (n == 3) {
                // TERCETO: A-A (primero y ultimo iguales, y NO los tres iguales)
                if (rimaCons[0].equals(rimaCons[2]) && !rimaCons[0].equals(rimaCons[1])) {
                    resultado = "TERCETO";
                }
            } else if (n == 4) {
                // CUADERNA VIA: AAAA
                if (rimaCons[0].equals(rimaCons[1]) && rimaCons[0].equals(rimaCons[2]) && rimaCons[0].equals(rimaCons[3])) {
                    resultado = "CUADERNA VIA";
                }
                // CUARTETO: ABBA
                else if (rimaCons[0].equals(rimaCons[3]) && rimaCons[1].equals(rimaCons[2]) && !rimaCons[0].equals(rimaCons[1])) {
                    resultado = "CUARTETO";
                }
                // CUARTETA: ABAB
                else if (rimaCons[0].equals(rimaCons[2]) && rimaCons[1].equals(rimaCons[3]) && !rimaCons[0].equals(rimaCons[1])) {
                    resultado = "CUARTETA";
                }
                // SEGUIDILLA: -a-a (asonante en pares)
                else if (rimaAson[1].equals(rimaAson[3])
                         && !rimaAson[0].equals(rimaAson[1])
                         && !rimaAson[0].equals(rimaAson[3])
                         && !rimaAson[2].equals(rimaAson[1])
                         && !rimaAson[2].equals(rimaAson[3])
                         && !rimaCons[1].equals(rimaCons[3])) { // asonante, no consonante
                    resultado = "SEGUIDILLA";
                }
            }

            System.out.println(resultado);
        }
        sc.close();
    }
}
