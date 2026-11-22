import java.util.Scanner;

public class EsMatrizIdentidad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            // Hay que leer la matriz entera aunque ya aparezca un valor malo
            boolean identidad = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int valor = sc.nextInt();
                    if (i == j) {
                        if (valor != 1) {
                            identidad = false;
                        }
                    } else if (valor != 0) {
                        identidad = false;
                    }
                }
            }
            System.out.println(identidad ? "SI" : "NO");
        }
        sc.close();
    }
}
