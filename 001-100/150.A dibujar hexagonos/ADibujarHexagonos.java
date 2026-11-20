import java.util.Scanner;

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
