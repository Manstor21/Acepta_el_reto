import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumaDigitos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            long n = sc.nextLong();
            if (n < 0) {
                break;
            }

            List<Long> digitos = new ArrayList<>();
            if (n == 0) {
                digitos.add(0L);
            } else {
                while (n > 0) {
                    digitos.add(0, n % 10);
                    n /= 10;
                }
            }

            long suma = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digitos.size(); i++) {
                if (i > 0) {
                    sb.append(" + ");
                }
                sb.append(digitos.get(i));
                suma += digitos.get(i);
            }
            sb.append(" = ").append(suma);
            System.out.println(sb);
        }
        sc.close();
    }
}