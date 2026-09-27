import java.util.Scanner;

public class ViajeTiempo {

    static final int LIMITE = 1000000;

    // Diferencia circular de 'a' a 'b': lo que hay que sumar a 'a' para llegar a 'b'
    private static int diferencia(int a, int b) {
        int d = (b - a) % LIMITE;
        if (d < 0) {
            d += LIMITE;
        }
        return d;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();

        for (int c = 0; c < casos; c++) {
            int anterior = sc.nextInt();
            int actual = sc.nextInt();

            int constante = diferencia(anterior, actual);
            int cambios = 0;

            anterior = actual;
            while (true) {
                actual = sc.nextInt();
                if (actual == -1) {
                    break;
                }

                int esperado = (anterior + constante) % LIMITE;
                if (actual != esperado) {
                    cambios++;
                    constante = diferencia(anterior, actual);
                }
                anterior = actual;
            }

            int siguiente = (anterior + constante) % LIMITE;
            System.out.println(cambios + " " + siguiente);
        }
    }
}