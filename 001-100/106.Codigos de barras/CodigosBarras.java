import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

/*
 * Problema 106 - Codigos de barras
 *
 * Validamos codigos EAN-8 y EAN-13 comprobando su digito de control.
 *
 * El digito de control se calcula asi:
 *   1. Empezando por la derecha (sin contar el digito de control),
 *      sumamos los digitos multiplicados por un factor:
 *        - Posiciones impares (desde la derecha): multiplicar por 3
 *        - Posiciones pares: multiplicar por 1
 *   2. El digito de control es lo que hay que sumar para llegar
 *      al multiplo de 10 superior. Si ya es multiplo de 10, es 0.
 *
 * Si el codigo tiene menos de 8 digitos, asumimos EAN-8 y
 * completamos con ceros a la izquierda.
 * Si tiene entre 9 y 12 digitos, asumimos EAN-13 y completamos.
 *
 * Para EAN-13, si el digito es correcto, mostramos el pais
 * segun la tabla de codigos de pais.
 */
public class CodigosBarras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        // Tabla de codigos de pais (solo los que aparecen en el enunciado)
        Map<String, String> paises = new HashMap<>();
        paises.put("0", "EEUU");
        paises.put("380", "Bulgaria");
        paises.put("50", "Inglaterra");
        paises.put("539", "Irlanda");
        paises.put("560", "Portugal");
        paises.put("70", "Noruega");
        paises.put("759", "Venezuela");
        paises.put("850", "Cuba");
        paises.put("890", "India");

        while (sc.hasNext()) {
            String linea = sc.next();
            if (linea.equals("0")) break;

            // Completar con ceros a la izquierda segun el tipo
            String codigo;
            boolean esEan13;
            if (linea.length() < 8) {
                codigo = String.format("%08d", Long.parseLong(linea));
                esEan13 = false;
            } else if (linea.length() > 8) {
                codigo = String.format("%013d", Long.parseLong(linea));
                esEan13 = true;
            } else {
                codigo = linea;
                esEan13 = false;
            }

            // Calcular la suma para el digito de control
            int suma = 0;
            for (int i = 0; i < codigo.length() - 1; i++) {
                int digito = codigo.charAt(i) - '0';
                // Posiciones pares desde la derecha (sin contar control) se multiplican por 3
                // La posicion del ultimo digito (sin control) es 1 (impar) -> *3
                int posicionDesdeDerecha = codigo.length() - 1 - i;
                if (posicionDesdeDerecha % 2 == 1) {
                    suma += digito * 3;
                } else {
                    suma += digito * 1;
                }
            }

            int digitoControlReal = codigo.charAt(codigo.length() - 1) - '0';
            int digitoControlCalculado = (10 - (suma % 10)) % 10;

            if (digitoControlReal == digitoControlCalculado) {
                if (esEan13) {
                    // Buscar pais con los primeros digitos
                    String prefijo = codigo.substring(0, 3);
                    String pais = paises.getOrDefault(prefijo, "Desconocido");
                    // Tambien probar con 2 digitos si no se encuentra con 3
                    if (pais.equals("Desconocido")) {
                        prefijo = codigo.substring(0, 2);
                        pais = paises.getOrDefault(prefijo, "Desconocido");
                    }
                    System.out.println("SI " + pais);
                } else {
                    System.out.println("SI");
                }
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
