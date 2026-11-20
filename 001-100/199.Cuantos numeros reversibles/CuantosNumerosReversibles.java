import java.util.Scanner;

public class CuantosNumerosReversibles {

    private static long potencia(long base, int exp) {
        long r = 1L;
        for (int i = 0; i < exp; i++) {
            r *= base;
        }
        return r;
    }

    // n tiene d digitos y no termina en 0. Al sumar n + reverse(n) columna a
    // columna, el acarreo entrante determina la paridad exigida a la suma de
    // cada par simetrico de digitos. Trabajando desde ambos extremos:
    //   d = 2m  -> solo cabe acarreo final 0; el par exterior tiene 20 opciones
    //              (suma impar de 3 a 9) y cada par interior 30 (suma 1,3,5,7,9).
    //              Total: 20 * 30^(m-1).
    //   d = 2m+1 -> solo cabe acarreo final 1 y ademas m debe ser impar.
    //              Pares exteriores/interiores segun paridad: 20 y 25 opciones;
    //              el digito central tiene 5 opciones (0..4).
    //              Total: 5 * 20^((m+1)/2) * 25^((m-1)/2); si m es par, 0.
    private static long contar(int d) {
        if (d == 1) {
            return 0L;
        }
        if (d % 2 == 0) {
            int m = d / 2;
            return 20L * potencia(30L, m - 1);
        }
        int m = (d - 1) / 2;
        if (m % 2 == 0) {
            return 0L;
        }
        return 5L * potencia(20L, (m + 1) / 2) * potencia(25L, (m - 1) / 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int d = sc.nextInt();
            if (d == 0) {
                break;
            }
            System.out.println(contar(d));
        }
        sc.close();
    }
}
