import java.util.Scanner;

/*
 * La fila central lleva 2*n-1 caracteres; hacia arriba y abajo
 * se quitan 2 caracteres por fila y se anade 1 espacio delante.
 * Asi el centro cae en la fila n-1 y no hay que dibujar lados inclinados.
 */
public class ADibujarHexagonos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            String caracter = sc.next();
            if (n == 0 && caracter.equals("0")) {
                break;
            }
            char c = caracter.charAt(0);
            for (int fila = 0; fila < 2 * n - 1; fila++) {
                int distancia = Math.abs(fila - (n - 1));
                int blancos = distancia;
                int caracteres = n + 2 * (n - 1 - distancia);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < blancos; i++) {
                    sb.append(' ');
                }
                for (int i = 0; i < caracteres; i++) {
                    sb.append(c);
                }
                System.out.println(sb);
            }
        }
        sc.close();
    }
}
