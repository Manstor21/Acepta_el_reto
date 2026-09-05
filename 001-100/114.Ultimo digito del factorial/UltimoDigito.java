import java.util.Scanner;

/*
 * Problema 114 - Ultimo digito del factorial
 *
 * Para cada numero de entrada hay que mostrar el ultimo digito
 * (el de la derecha) de su factorial.
 *
 * El factorial crece rapidisimo, pero solo nos interesa el ultimo
 * digito. A partir de 5!, el factorial siempre contiene un factor 10
 * (5 * 2), asi que su ultimo digito es 0. Para los valores pequenos:
 *   0! = 1, 1! = 1, 2! = 2, 3! = 6, 4! = 4
 * y para n >= 5 el ultimo digito es 0.
 */
public class UltimoDigito {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int casos = sc.nextInt();

        for (int i = 0; i < casos; i++) {
            int n = sc.nextInt();

            if (n >= 5) {
                System.out.println(0);
            } else {
                // Valores pequenos: 0!, 1!, 2!, 3!, 4!
                int ultimo = 1;
                for (int f = 2; f <= n; f++) {
                    ultimo *= f;
                }
                System.out.println(ultimo % 10);
            }
        }

        sc.close();
    }
}
