import java.util.Scanner;

public class Ano2013 {
    private static final int MINIMO = 1000;
    private static final int MAXIMO = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();

        while (casos-- > 0) {
            long anio = sc.nextLong();
            boolean sinRepetir = sinDigitosRepetidos(anio);

            long inicio = anio;
            while (inicio > MINIMO && sinDigitosRepetidos(inicio - 1) == sinRepetir) {
                inicio--;
            }

            long fin = anio;
            while (fin < MAXIMO && sinDigitosRepetidos(fin + 1) == sinRepetir) {
                fin++;
            }

            System.out.println(inicio + " " + (fin - inicio + 1));
        }
    }

    private static boolean sinDigitosRepetidos(long n) {
        boolean[] vista = new boolean[10];

        while (n > 0) {
            int digito = (int) (n % 10);
            if (vista[digito]) {
                return false;
            }
            vista[digito] = true;
            n /= 10;
        }

        return true;
    }
}
