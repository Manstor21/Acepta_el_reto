import java.util.Scanner;

/*
 * Problema 122 - Avituallamiento en las etapas ciclistas
 *
 * Cada etapa es una secuencia de alturas (una por PK) que termina con un
 * -1. Un kilometro es "llano" si la altura al principio es IGUAL a la
 * altura al final (altura[i] == altura[i+1]).
 *
 * Se pide el punto kilometrico donde colocar el avituallamiento (el inicio
 * de la zona llana mas larga) y el numero de kilometros llanos por delante
 * (la longitud de esa zona). En caso de empate se elige la menor PK. Si no
 * hay ninguna zona llana se escribe "HOY NO COMEN".
 *
 * La secuencia puede ser de longitud variable, por eso leemos la linea
 * completa y la procesamos hasta el -1.
 */
public class Avituallamiento {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String linea = sc.nextLine().trim();
            if (linea.isEmpty()) continue;

            // Si la linea es solo "-1", se acaba la entrada.
            if (linea.equals("-1")) break;

            String[] partes = linea.split(" ");
            int[] alturas = new int[partes.length - 1]; // sin el -1 final
            for (int i = 0; i < alturas.length; i++) {
                alturas[i] = Integer.parseInt(partes[i]);
            }

            int mejorPk = -1;
            int mejorLong = 0;

            int i = 0;
            while (i < alturas.length - 1) {
                if (alturas[i] == alturas[i + 1]) {
                    int inicio = i;
                    while (i < alturas.length - 1 && alturas[i] == alturas[i + 1]) {
                        i++;
                    }
                    int longitud = i - inicio;
                    if (longitud > mejorLong) {
                        mejorLong = longitud;
                        mejorPk = inicio;
                    }
                } else {
                    i++;
                }
            }

            if (mejorPk == -1) {
                System.out.println("HOY NO COMEN");
            } else {
                System.out.println(mejorPk + " " + mejorLong);
            }
        }

        sc.close();
    }
}
