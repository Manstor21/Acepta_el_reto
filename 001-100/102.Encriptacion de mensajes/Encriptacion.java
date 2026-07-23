import java.util.Scanner;

/*
 * Problema 102 - Encriptacion de mensajes
 *
 * Cifrado de Cesar: cada letra se desplaza un numero fijo de
 * posiciones en el alfabeto. El primer caracter de cada linea
 * nos dice el desplazamiento (es la 'p' codificada).
 *
 * Si el primer caracter es 'q', el desplazamiento es 1
 * (porque q = p + 1). Para descifrar, restamos ese
 * desplazamiento a cada letra.
 *
 * Solo se codifican letras (a-z, A-Z), el resto queda igual.
 * El programa termina cuando el mensaje descifrado es "FIN".
 * Para cada caso se cuenta el numero de vocales del mensaje.
 */
public class Encriptacion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
            if (linea.isEmpty()) continue;

            // El primer caracter nos dice el desplazamiento
            int desp = linea.charAt(0) - 'p';
            String mensaje = linea.substring(1);

            // Desciframos el mensaje
            StringBuilder descifrado = new StringBuilder();
            for (int i = 0; i < mensaje.length(); i++) {
                char c = mensaje.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    // Letra minuscula: restamos el desplazamiento y envolvemos
                    descifrado.append((char) ('a' + (c - 'a' - desp + 26) % 26));
                } else if (c >= 'A' && c <= 'Z') {
                    // Letra mayuscula: idem
                    descifrado.append((char) ('A' + (c - 'A' - desp + 26) % 26));
                } else {
                    // Cualquier otro caracter queda igual
                    descifrado.append(c);
                }
            }

            // Si el mensaje descifrado es "FIN", terminamos
            if (descifrado.toString().equals("FIN")) break;

            // Contamos las vocales
            int vocales = 0;
            for (int i = 0; i < descifrado.length(); i++) {
                char c = descifrado.charAt(i);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                    c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                    vocales++;
                }
            }

            System.out.println(vocales);
        }
        sc.close();
    }
}
