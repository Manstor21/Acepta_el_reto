import java.util.Scanner;

/*
 * Problema 165 - Numero hyperpar
 *
 * Un numero es hyperpar si todos sus digitos son pares (0, 2, 4, 6 u 8).
 * Se leen las lines hasta encontrar un numero negativo, que marca el
 * final de los casos de prueba.
 */
public class NumeroHyperpar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String numero = sc.next();
            if (numero.charAt(0) == '-') {
                break;
            }

            boolean hyperpar = true;
            for (int i = 0; i < numero.length(); i++) {
                if ((numero.charAt(i) - '0') % 2 != 0) {
                    hyperpar = false;
                    break;
                }
            }

            System.out.println(hyperpar ? "SI" : "NO");
        }
        sc.close();
    }
}
